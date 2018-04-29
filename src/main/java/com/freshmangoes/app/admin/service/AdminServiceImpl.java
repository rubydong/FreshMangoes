package com.freshmangoes.app.admin.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.MediaType;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentMetadata;
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

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
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
  public void deleteDetailPage(final Integer contentId) {
    /*
      Since movieRepository and showRepository point to `Content` table,
      deleting from one of the two repositories will do the job.
    */
    movieRepository.deleteById(contentId);
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
    final User user = (User) session.getAttribute(Constants.USER_ID);
    return (user != null && user.getType() == UserType.ADMIN);
  }

  @Override
  public Content jsonToContent(final String body) {
    Content content = null;
    try {
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

      // first do summaryphoto
      content.setSummaryPhoto(mediaRepository.save(content.getSummaryPhoto()));

      // then all other media
      List<Media> unsavedMedia = content.getMedia();
      content.setMedia(new ArrayList<>());
      for (Media m : unsavedMedia) {
        content.getMedia().add(mediaRepository.save(m));
      }

      // then metadata
      content.setMetadata(metadataRepository.save(content.getMetadata()));

      switch (contentType) {
        case MOVIE:
          content = movieRepository.save((Movie) content);
          break;
        case SHOW:
          content = showRepository.save((Show) content);
          break;
        case SEASON:
          content = seasonRepository.save((Season) content);
          break;
        case EPISODE:
          content = episodeRepository.save((Episode) content);
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
          celebrity.setProfilePicture(mediaRepository.save(celebrity.getProfilePicture()));
          castedRepository.save(Cast.builder().content(content).celebrity(celebrityRepository.save(celebrity)).role(cast.getRole()).build());
        } else {
          celebrity = celebrityRepository.findById(celebrity.getId()).orElse(null);
          if (celebrity != null) {
            castedRepository.save(Cast.builder().content(content).celebrity(celebrity).role(cast.getRole()).build());
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
}
