package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.contentType;
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

  private Map<String, User> userMap;
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
                  .type(contentType.MOVIE)
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
                  .type(contentType.SHOW)
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
                  .type(contentType.MOVIE)
                  .contentMetadata(ContentMetadata.builder()
                      .name("Avengers: Infinity War")
                      .releaseDate(new Date(1483228800000L))
                      .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/avengers.jpg"))
                  .build()
          )
          .add(
              Movie.builder()
                  .type(contentType.MOVIE)
                  .contentMetadata(ContentMetadata.builder()
                      .name("Pitch Perfect 3")
                      .releaseDate(new Date(1483228800000L))
                      .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/pitchperfect3.jpeg"))
                  .build()
          )
          .add(
              Movie.builder()
                  .type(contentType.MOVIE)
                  .contentMetadata(ContentMetadata.builder()
                      .name("Red Sparrow")
                      .releaseDate(new Date(1483228800000L))
                      .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/redsparrow.jpg"))
                  .build()
          )
          .build();

      List<Content> uninterested = new ImmutableList.Builder<Content>()
          .add(
              Movie.builder()
                  .type(contentType.MOVIE)
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
                  .type(contentType.MOVIE)
                  .contentMetadata(ContentMetadata.builder()
                      .name("A Wrinkle in Time")
                      .releaseDate(new Date(1483228800000L))
                      .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/wrinkleintime.jpg"))
                  .build()
          )
          .add(
              Movie.builder()
                  .type(contentType.MOVIE)
                  .contentMetadata(ContentMetadata.builder()
                      .name("The Greatest Showman")
                      .releaseDate(new Date(1483228800000L))
                      .build()
                  )
                  .summaryPhoto(new URL("http://images/posters/greatestshowman.jpg"))
                  .build()
          )
          .build();
      if (id % 2 == 0) {
        return User.builder()
            .id(0)
            .displayName("Ruby Dong")
            .numFollowers(34)
            .numFollowing(56)
            .profilePicture(new URL("http://images/usericon.png"))
            .interestedList(interested)
            .disinterestedList(uninterested)
            .build();
      }

      return User.builder()
          .id(1)
          .displayName("Bob")
          .numFollowers(67)
          .numFollowing(89)
          .profilePicture(new URL("http://images/usericon2.png"))
          .interestedList(uninterested)
          .disinterestedList(interested)
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
