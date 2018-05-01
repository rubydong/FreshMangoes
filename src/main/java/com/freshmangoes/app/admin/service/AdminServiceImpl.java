package com.freshmangoes.app.admin.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.CastedRepository;
import com.freshmangoes.app.content.repository.EpisodeRepository;
import com.freshmangoes.app.content.repository.MediaRepository;
import com.freshmangoes.app.content.repository.MetadataRepository;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.SeasonRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.Application;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private SeasonRepository seasonRepository;

  @Autowired
  private EpisodeRepository episodeRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private CastedRepository castedRepository;

  @Autowired
  private CelebrityRepository celebrityRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MediaRepository mediaRepository;

  @Autowired
  private MetadataRepository metadataRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public Boolean createMovieDetailPage(final Movie movie) {
    movieRepository.save(movie);
    return null;
  }

  @Override
  public Boolean createShowDetailPage(final Show show) {
    showRepository.save(show);
    return null;
  }

  @Override
  public Boolean updateMovieDetailPage(final Movie movie) {
    return null;
  }

  @Override
  public Boolean updateShowDetailPage(final Show show) {
    return null;
  }

  @Override
  public void deleteDetailPage(final Integer contentId, ContentType type) {
    switch (type) {
      case MOVIE:
        movieRepository.deleteById(contentId);
        break;
      case SHOW:
        showRepository.deleteById(contentId);
        break;
      case SEASON:
        seasonRepository.deleteById(contentId);
        break;
      case EPISODE:
        episodeRepository.deleteById(contentId);
        break;
    }
  }

  @Override
  public List<Rating> getReport() {
    return ratingRepository.findFlaggedRatings();
  }

  @Override
  public void deleteRating(final Integer ratingId) {
    ratingRepository.deleteById(ratingId);
  }

  @Override
  public void deleteUser(final Integer userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public Boolean isAuthenticatedAdmin(final HttpSession session) {
    final User user = userRepository.findById((Integer) session.getAttribute(Constants.USER_ID)).orElse(null);
    return (user != null && user.getType() == UserType.ADMIN);
  }

  @Override
  public Content jsonToContent(final String body) {
    Content content = null;
    try {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      JsonNode root = objectMapper.readTree(body);
      ContentType contentType = ContentType.valueOf(root.path("type").asText());
      switch (contentType) {
        case MOVIE:
          content = objectMapper.readValue(body, Movie.class);
          break;
        case SHOW:
          content = objectMapper.readValue(body, Show.class);
          break;
        case SEASON:
          content = objectMapper.readValue(body, Season.class);
          break;
        case EPISODE:
          content = objectMapper.readValue(body, Episode.class);
          break;
      }

      content.setViews(BigInteger.ZERO);

      if (content.getSummaryPhoto() != null) {
        content.setSummaryPhoto(mediaRepository.save(content.getSummaryPhoto()));
      }

      List<Media> unsavedMedia = content.getMedia();
      content.setMedia(new ArrayList<>());
      for (Media m : unsavedMedia) {
        content.getMedia().add(mediaRepository.save(m));
      }

      content.setMetadata(metadataRepository.save(content.getMetadata()));

      switch (contentType) {
        case MOVIE:
          content = movieRepository.save((Movie) content);
          break;
        case SHOW:
          content = showRepository.save((Show) content);
          break;
        case SEASON:
          Show show = showRepository.findById(root.path("showId").asInt()).orElse(null);
          if (show == null) {
            return null;
          }
          content = seasonRepository.save((Season) content);
          show.getSeasons().add((Season) content);
          showRepository.save(show);
          break;
        case EPISODE:
          Show show2 = showRepository.findById(root.path("showId").asInt()).orElse(null);
          Integer actualSeason = root.path("seasonId").asInt() - 1;
          if (show2 == null || actualSeason < 0 || actualSeason > show2.getSeasons().size()-1) {
            return null;
          }
          content = episodeRepository.save((Episode) content);
          show2.getSeasons().get(actualSeason).getEpisodes().add((Episode) content);
          showRepository.save(show2);
          break;
      }

      // do celebrities now
      // check celebrity id, if it exists find and add into cast, if not create new celebrity
      List<Cast> unsavedCast = content.getCast();
      content.setCast(new ArrayList<>());
      for (Cast cast : unsavedCast) {
        Celebrity celebrity = cast.getCelebrity();
        if (celebrity.getId() == -1) {
          // create a new celebrity here
          //  media -> celebrities, casted (mainly just profile and celebrities, then put the new celebrities into content object)
          if (celebrity.getProfilePicture() != null) {
            celebrity.setProfilePicture(mediaRepository.save(celebrity.getProfilePicture()));
          }
          content
              .getCast()
              .add(castedRepository.save(Cast
                  .builder()
                  .content(content)
                  .celebrity(celebrityRepository.save(celebrity)).role(cast.getRole()).build()));
        } else {
          celebrity = celebrityRepository.findById(celebrity.getId()).orElse(null);
          if (celebrity != null) {
            content
                .getCast()
                .add(castedRepository.save(
                    Cast
                        .builder()
                        .content(content)
                        .celebrity(celebrity)
                        .role(cast.getRole()).build()));
          }
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  @Override
  public List<Application> getAllPotentialCritics() {
    return userRepository.getAllPotentialCritics()
        .stream()
        .map(user -> Application
            .builder()
            .user(user)
            .statement(userRepository.getCriticApplicationStatement(user.getId()))
            .build())
        .collect(Collectors.toList());
  }

  @Override
  public User approveUserToCritic(final Integer userId) {
    final User user = userRepository.findById(userId).orElse(null);
    if (user == null || userRepository.appliedForCritic(userId) == null) {
      return null;
    }
    userRepository.deleteCriticApplication(userId);
    user.setType(UserType.CRITIC);
    return userRepository.save(user);
  }

  @Override
  public String uploadMedia(MultipartFile f) {
    File temp = new File(Constants.FILE_PATH + f.getOriginalFilename());
    try {
      if (!temp.getParentFile().exists()) {
        temp.getParentFile().mkdirs();
      }
      if (!temp.exists()) {
        temp.createNewFile();
        f.transferTo(temp);
        return temp.getCanonicalPath();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
