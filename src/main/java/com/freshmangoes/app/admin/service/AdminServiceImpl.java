package com.freshmangoes.app.admin.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.MediaType;
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

  private Content readContentByType(final String body, ContentType contentType) {
    Content content = null;
    try {
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
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  @Override
  public Content jsonToContent(final String body) {
    Content content = null;
    try {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      JsonNode root = objectMapper.readTree(body);
      ContentType contentType = ContentType.valueOf(root.path("type").asText());
      content = readContentByType(body, contentType);

      content.setViews(BigInteger.ZERO);

      if (content.getSummaryPhoto() != null) {
        content.setSummaryPhoto(mediaRepository.save(content.getSummaryPhoto()));
      }

      List<Media> unsavedMedia = content.getMedia();
      content.setMedia(new ArrayList<>());
      addMedia(content, unsavedMedia);

      content.setMetadata(metadataRepository.save(content.getMetadata()));
      List<Cast> unsavedCast = content.getCast();
      content.setCast(null);

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
          if (show2 == null || actualSeason < 0 || actualSeason > show2.getSeasons().size() - 1) {
            return null;
          }
          content = episodeRepository.save((Episode) content);
          show2.getSeasons().get(actualSeason).getEpisodes().add((Episode) content);
          showRepository.save(show2);
          break;
      }

      // do celebrities now
      // check celebrity id, if it exists find and add into cast, if not create new celebrity
      addCast(unsavedCast, content);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  private void addMedia(Content content, List<Media> unsavedMedia) {
    for (Media m : unsavedMedia) {
      content.getMedia().add(mediaRepository.save(m));
    }
  }

  private void addCast(List<Cast> unsavedCast, Content content) {
    for (Cast cast : unsavedCast) {
      Celebrity celebrity = cast.getCelebrity();
      if (celebrity.getId() == -1) {
        // create a new celebrity here
        //  media -> celebrities, casted (mainly just profile and celebrities, then put the new celebrities into content object)
        if (celebrity.getProfilePicture() != null) {
          celebrity.setProfilePicture(mediaRepository.save(celebrity.getProfilePicture()));
        }
        castedRepository.save(
         Cast
          .builder()
          .content(content)
          .celebrity(celebrityRepository.save(celebrity)).role(cast.getRole()).build());
      } else {
        celebrity = celebrityRepository.findById(celebrity.getId()).orElse(null);
        if (celebrity != null) {
          castedRepository.save(
           Cast
            .builder()
            .content(content)
            .celebrity(celebrity)
            .role(cast.getRole()).build());
        }
      }
    }
  }

  @Override
  public Content editCast(final String json, final Integer contentId) {
    Content content = null;
    try {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      JsonNode root = objectMapper.readTree(json);
      ContentType contentType = ContentType.valueOf(root.path("type").asText());
      content = readContentByType(json, contentType);

      Content originalContent = findContentByType(contentType, contentId);
      if (originalContent == null) {
        return null;
      }

      List<Cast> newCast = content.getCast();
      addCast(newCast, originalContent);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  @Override
  public Content editMedia(final String json, final Integer contentId) {
    Content content = null;
    try {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      JsonNode root = objectMapper.readTree(json);
      ContentType contentType = ContentType.valueOf(root.path("type").asText());
      content = readContentByType(json, contentType);

      Content originalContent = findContentByType(contentType, contentId);
      if (originalContent == null) {
        return null;
      }

      addMedia(originalContent, content.getMedia());

      saveContentByType(originalContent, contentType);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  @Override
  public void deleteCast(Integer contentId, ContentType contentType, Integer celebrityId) {
    Content content = findContentByType(contentType, contentId);
    if (content == null) {
      return;
    }
    if (content.getCast() != null) {
      Cast toRemove = null;
      List<Cast> casts = content.getCast();
      for (Cast c : casts) {
        Celebrity celebrity = c.getCelebrity();
        if (celebrity.getId().equals(celebrityId)) {
          toRemove = c;
          break;
        }
      }
      if (toRemove != null) {
//        toRemove.setCelebrity(null);
//        toRemove.setContent(null);
        casts.remove(toRemove);
        saveContentByType(content, contentType);
        castedRepository.delete(toRemove);
      }
    }

  }

  @Override
  public Content editContentSummary(final String json, final Integer contentId) {
    Content oldContent = null;
    try {
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      JsonNode root = objectMapper.readTree(json);
      String summaryPhoto = root.path("summaryPhoto").asText();
      ContentType contentType = ContentType.valueOf(root.path("type").asText());
      oldContent = findContentByType(contentType, contentId);

      if (oldContent == null) {
        return null;
      }

      oldContent.getMetadata().setName(root.path("name").asText());
      oldContent.getMetadata().setSummary(root.path("summary").asText());

      // if new image exist, delete old and insert new
      if (summaryPhoto.length() > 0) {
        if (oldContent.getSummaryPhoto() != null) {
          Media m = oldContent.getSummaryPhoto();
          oldContent.setSummaryPhoto(null);
          mediaRepository.delete(m);
        }
        oldContent.setSummaryPhoto(mediaRepository.save(Media.builder().path(summaryPhoto).type(MediaType.PHOTO).build()));
      }

      // set new genres
      oldContent.getMetadata().getGenres().clear();
      JsonNode genres = root.path("genre");
      for (JsonNode jn : genres) {
        oldContent.getMetadata().getGenres().add(jn.asInt());
      }

      oldContent = saveContentByType(oldContent, contentType);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return oldContent;
  }

  private Content findContentByType(ContentType contentType, Integer contentId) {
    Content oldContent = null;
    switch (contentType) {
      case MOVIE:
        oldContent = movieRepository.findById(contentId).orElse(null);
        break;
      case SHOW:
        oldContent = showRepository.findById(contentId).orElse(null);
        break;
      case SEASON:
        oldContent = seasonRepository.findById(contentId).orElse(null);
        break;
      case EPISODE:
        oldContent = episodeRepository.findById(contentId).orElse(null);
        break;
    }
    return oldContent;
  }

  private Content saveContentByType(Content content, ContentType contentType) {
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
    return content;
  }

  @Override
  public void deleteMedia(Integer contentId, ContentType contentType, Integer mediaId) {
    Content oldContent = findContentByType(contentType, contentId);
    if (oldContent == null) {
      return;
    }
    if (oldContent.getMedia() != null) {
      List<Media> medias = oldContent.getMedia();
      Media toRemove = null;
      for (Media m : medias) {
        if (m.getId() == mediaId) {
          toRemove = m;
          break;
        }
      }
      if (toRemove != null) {
        medias.remove(toRemove);
        mediaRepository.delete(toRemove);
        saveContentByType(oldContent, contentType);
      }
    }
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
