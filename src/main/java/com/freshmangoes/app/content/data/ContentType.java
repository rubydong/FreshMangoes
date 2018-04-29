package com.freshmangoes.app.content.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContentType {
  MOVIE(Values.MOVIE),
  SHOW(Values.SHOW),
  SEASON(Values.SEASON),
  EPISODE(Values.EPISODE);

  private String value;

  public static class Values {
    public static final String MOVIE = "0";
    public static final String SHOW = "1";
    public static final String SEASON = "2";
    public static final String EPISODE = "3";
  }
}