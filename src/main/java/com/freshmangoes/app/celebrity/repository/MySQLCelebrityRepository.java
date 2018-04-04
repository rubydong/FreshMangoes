package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;

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
  public Celebrity findCelebrityById(int id) {
    try {
      return Celebrity
          .builder()
          .name("Chadwick Boseman")
          .id(id)
          .type(CelebrityType.Actor)
          .profilePhoto(new URL("https://goo.gl/wdpmKu"))
          .birthplace("Anderson, SC")
          .birthday(new Date(880782472000L))
          .biography("Little League baseball but primarily played basketball. Studied acting "
              + "at the British American Drama Academy in Oxford after graduating from Howard "
              + "University in Washington, United States. ")
          .media(null)
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Celebrity> findAllLikeKeyword(String searchQuery) {
    List <Celebrity> celebrities = new ArrayList<>();
    try {
      celebrities.add(
          Celebrity
          .builder()
          .name("Steven Spielberg")
          .id(8)
          .type(CelebrityType.Director)
          .profilePhoto(new URL("goo.gl/rcqkrJ"))
          .birthplace("Cincinnati, OH")
          .birthday(new Date(-727052823000L))
          .biography("Highest grossing director of all time. ")
          .media(null)
          .build());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
