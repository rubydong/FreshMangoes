package com.freshmangoes.app.admin.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.MediaType;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
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

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private UserRepository userRepository;

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

//  @Override
//  public Content jsonToContent(String json) {
//    return null;
//  }

//  public Movie jsonToMovie(String json) {
//    System.out.println("start function");
//    String title;
//    String summary;
//    Media summaryPhoto;
//    List<Integer> genres;
//    List<Media> media;
//    List<Cast> cast;
//
//    try {
//      JsonNode root = objectMapper.readTree(json);
//      JsonNode placeHolder;
//
//      title = root.path("title").asText();
//      summary = root.path("summary").asText();
//
//      System.out.println(title);
//      System.out.println(summary);
//
//      // Get summary photo
//      placeHolder = root.path("summaryPhoto");
//      summaryPhoto = Media
//       .builder()
//       .path(new URL(placeHolder.path("path").asText()))
//       .type(MediaType.PHOTO)
//       .build();
//
//      // Get genres
//      placeHolder = root.path("genres");
//      genres = new ArrayList<Integer>();
//      for (JsonNode node : placeHolder) {
//        genres.add(node.asInt());
//      }
//
//      // Get Media
//      placeHolder = root.path("media");
//      media = new ArrayList<Media>();
//      for (JsonNode node : placeHolder) {
//        media.add(Media
//         .builder()
//         .path(new URL(node.path("path").asText()))
//         .type(node.path("type").asText().equals("PHOTO") ? MediaType.PHOTO : MediaType.VIDEO)
//         .build());
//      }
//
//      // Get Celebrity
//      placeHolder = root.path("cast");
//      cast = new ArrayList<Cast>();
//      for (JsonNode node : placeHolder) {
//        JsonNode celebrity = node.path("celebrity");
//        JsonNode pic = celebrity.path("profilePicture");
//        Cast c = Cast
//         .builder()
//         .role(node.path("role").asText())
//         .celebrity(Celebrity
//          .builder()
//          .name(celebrity.path("name").asText())
//          .profilePicture(pic != null
//           ? Media.builder().path(new URL(pic.path("path").asText())).type(MediaType.PHOTO).build()
//           : null)
//          .build())
//         .build();
//        cast.add(c);
//      }
//
//      System.out.println("end function success");
//
//      // Create everything not related
//
//      Movie m = Movie
//       .builder()
//       .media(media)
//       .cast(cast)
//       .summaryPhoto(summaryPhoto)
//       .contentMetadata(ContentMetadata
//       .builder()
//       .name(title)
//       .summary(summary)
//       .genres(genres)
//       .build())
//       .build();
//
//      movieRepository.save(m);
//
//      return m;
//
//    } catch (JsonGenerationException e) {
//      e.printStackTrace();
//    } catch (JsonMappingException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    return null;
//  }

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
