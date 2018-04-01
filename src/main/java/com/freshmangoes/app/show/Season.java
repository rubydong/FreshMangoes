package com.freshmangoes.app.show;


import java.util.List;


import com.freshmangoes.app.show.Episode;



public class Season {
  private List<Episode> episodes;

  public Season() {
    super();
  }

  public List<Episode> getEpisodes() {
    return episodes;
  }

  public void setEpisodes(List<Episode> episodes) {
    this.episodes = episodes;
  }
}
