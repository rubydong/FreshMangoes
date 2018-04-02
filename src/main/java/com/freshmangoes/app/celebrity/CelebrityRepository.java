package com.freshmangoes.app.celebrity;
//import org.springframework.data.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.common.data.Media;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Repository
public class CelebrityRepository {
  public Celebrity findCelebrityById(int id){
    Celebrity c = null;
    try {
      Media media = new Media();
      c = new Celebrity(id, CelebrityType.Actor, new URL("https://goo.gl/wdpmKu"), new Date(880782472000L),
          "Chadwick Boseman", "Anderson, SC", "Was an athlete as a child; involved with " +
          "Little League baseball but primarily played basketball. Studied acting at the British American Drama Academy " +
          "in Oxford after graduating from Howard University in Washington, United States. ", media, null);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return c;
  }
}
