package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.celebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.contentType;
import com.freshmangoes.app.content.data.Movie;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlCelebrityRepository implements CelebrityRepository {
  /**
   * Returns a Celebrity object. The id argument is obtained from the mapping.
   *
   * @param id the id associated with the current celebrity being viewed
   * @return the celebrity with the given id
   */
  public Celebrity findCelebrityById(final int id) {
    try {
      ArrayList <String> roles = new ArrayList<>();
      roles.add("T'Challa");
      roles.add("Black Panther");
      return Celebrity
          .builder()
          .id(id)
          .type(celebrityType.ACTOR)
          .profilePhoto(new URL("https://goo.gl/wdpmKu"))
          .birthday(new Date(880782472000L))
          .name("Chadwick Boseman")
          .birthplace("Anderson, South Carolina")
          .biography("Studied acting at the British American Drama Academy "
              + "in Oxford after graduating from Howard University in "
              + "Washington, United States. Originally aspired to be a director. "
              + "Made his TV debut in a 2003 episode of Third Watch.")
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://goo.gl/wdpmKu"))
                  .add(new URL("https://goo.gl/wdpmKu"))
                  .add(new URL("https://goo.gl/wdpmKu"))
                  .add(new URL("https://goo.gl/wdpmKu"))
                  .build())
              .videos(new ImmutableList.Builder<URL>().build())
              .build())
          .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
              .put("Black Panther",
                  new Pair<String, Movie>("T'Challa/Black Panther", Movie
                      .builder()
                      .id(0)
                      .type(contentType.MOVIE)
                      .contentMetadata(ContentMetadata
                          .builder()
                          .mangoScore(97.0)
                          .build())
                      .build()))
              .put("Gods of Egypt",
                  new Pair<String, Movie>("Thoth",
                      Movie
                          .builder()
                          .id(34)
                          .type(contentType.MOVIE)
                          .contentMetadata(ContentMetadata
                              .builder()
                              .mangoScore(34.0)
                              .build())
                          .build()))
              .put("Detroit 1-8-7",
                  new Pair<String, Movie>("Tommy Westin",
                      Movie
                          .builder()
                          .id(35)
                          .type(contentType.SHOW)
                          .contentMetadata(ContentMetadata
                              .builder()
                              .mangoScore(87.0)
                              .build())
                          .build()))
              .build())
          .highestRated(Movie
              .builder()
              .id(12)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Panther")
                  .mangoScore(97.0)
                  .build())
              .build())
          .lowestRated(Movie
              .builder()
              .id(13)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Gods of Egypt")
                  .mangoScore(15.0)
                  .build())
              .build())
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Celebrity> findAllLikeKeyword(final String searchQuery) {
    List<Celebrity> celebrities = new ArrayList<>();
    try {
      celebrities.add(
          Celebrity
              .builder()
              .id(12)
              .type(celebrityType.ACTOR)
              .profilePhoto(new URL("https://images/search/rachelblack.png"))
              .name("Rachel Black")
              .build());

      celebrities.add(
          Celebrity
              .builder()
              .id(13)
              .type(celebrityType.ACTOR)
              .profilePhoto(new URL("https://images/search/lisablack.png"))
              .name("Lisa Black")
              .build());

      celebrities.add(
          Celebrity
              .builder()
              .id(14)
              .type(celebrityType.ACTOR)
              .profilePhoto(new URL("https://images/search/conradblack.png"))
              .name("Conrad Black")
              .build());

      celebrities.add(
          Celebrity
              .builder()
              .id(12)
              .type(celebrityType.ACTOR)
              .profilePhoto(new URL("https://images/search/rachelblack.png"))
              .name("Rachel Black")
              .build());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return celebrities;
  }
}
