package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.ContentMetadata;
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
public class MySQLCelebrityRepository implements CelebrityRepository {
  /**
   * Returns a Celebrity object. The id argument is obtained from the mapping.
   *
   * @param id the id associated with the current celebrity being viewed
   * @return the celebrity with the given id
   */
  public Celebrity findCelebrityById(final int id) {
    try {
      return Celebrity
          .builder()
          .id(id)
          .type(CelebrityType.Actor)
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
          .roles(new ImmutableMap.Builder<String, String>()
              .put("Black Panther", "T'Challa")
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
              .name("Steven Spielberg")
              .id(8)
              .type(CelebrityType.Director)
              .media(Media
                  .builder()
                  .photos(new ArrayList<>())
                  .videos(new ArrayList<>())
                  .build())
              .profilePhoto(new URL("https://goo.gl/rcqkrJ"))
              .birthplace("Cincinnati, OH")
              .birthday(new Date(-727052823000L))
              .biography("Highest grossing director of all time. A lifelong cinema buff, he began "
                  + "directing his first short movies while still a child, later studying film at "
                  + "California State University and winning notice for his 1969 short feature "
                  + "Amblin'. He first made his mark in television, directing Joan Crawford in the "
                  + "pilot for Rod Serling's Night Gallery and working on episodes of Columbo "
                  + "and Marcus Welby, M.D. ")
              .roles(new ImmutableMap.Builder<String, String>()
                  .put("Ready Player One", "Director")
                  .build())
              .build());

      celebrities.add(
          Celebrity
              .builder()
              .id(12)
              .type(CelebrityType.Actor)
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
              .roles(new ImmutableMap.Builder<String, String>()
                  .put("Black Panther", "T'Challa")
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
              .build());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return celebrities;
  }
}
