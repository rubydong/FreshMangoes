package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.user.data.User;
import com.google.common.collect.ImmutableList;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRepository implements UserRepository {

  private Map <String, User> userMap;
  private int userCount;

  public MySqlUserRepository() {
    userMap = new HashMap<>();
    userCount = 0;
  }

  public User findByEmail(final String email) {
    return userMap.get(email);
  }

  @Override
  public User findById(Integer id) {
    try {
      List<Content> interested = new ImmutableList.Builder<Content>()
          .add(
              Movie.builder()
                   .type(ContentType.Movie)
                   .contentMetadata(ContentMetadata.builder()
                                                   .name("Black Panther")
                                                   .releaseDate(new Date(1483228800000L))
                                                   .build()
                   )
                   .summaryPhoto(new URL("http://images/movie/blackpanther.png"))
                   .build()
          )
          .add(
              Movie.builder()
                   .type(ContentType.Show)
                   .contentMetadata(ContentMetadata.builder()
                                                   .name("Stranger Things")
                                                   .releaseDate(new Date(1483228800000L))
                                                   .build()
                   )
                   .summaryPhoto(new URL("http://images/tvshow/strangerthings.png"))
                   .build()
          )
          .add(
              Movie.builder()
                   .type(ContentType.Movie)
                   .contentMetadata(ContentMetadata.builder()
                                                   .name("Avengers: Infinity War")
                                                   .releaseDate(new Date(1483228800000L))
                                                   .build()
                   )
                   .summaryPhoto(new URL("http://images/posters/avengers.jpg"))
                .build()
          )
          .build();

      List<Content> uninterested = new ImmutableList.Builder<Content>()
          .add(
              Movie.builder()
                   .type(ContentType.Movie)
                   .contentMetadata(ContentMetadata.builder()
                                                   .name("Coco")
                                                   .releaseDate(new Date(1483228800000L))
                                                   .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/coco.png"))
                  .build()
          )
          .add(
              Movie.builder()
                  .type(ContentType.Movie)
                  .contentMetadata(ContentMetadata.builder()
                                                  .name("A Wrinkle in Time")
                                                  .releaseDate(new Date(1483228800000L))
                                                  .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/wrinkleintime.jpg"))
                  .build()
          )
          .build();
      return User.builder()
                 .id(0)
                 .displayName("Ruby Dong")
                 .numFollowers(34)
                 .numFollowing(56)
                 .profilePicture(new URL("http://images/usericon.png"))
                 .interestedList(interested)
                 .notInterestedList(uninterested)
                 .build();
    } catch (Exception ex) {
      return null;
    }
  }

  public User save(final User user) {
    if (userMap.containsKey(user.getEmail())) {
      user.setId(null);
      return user;
    }

    user.setId(userCount++);
    userMap.put(user.getEmail(), user);
    return user;
  }

}
