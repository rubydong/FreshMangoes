package com.freshmangoes.app.common.data;

public class Constants {
  public static final String INDEX_MAPPING = "/index";
  public static final String LOGIN_MAPPING = "/login";
  public static final String LOGOUT_MAPPING = "/logout";
  public static final String REGISTER_MAPPING = "/register";
  public static final String CURRENT_USER_MAPPING = "/getCurrentUser";
  public static final String SEARCH_MAPPING = "/search";
  public static final String CELEBRITY_MAPPING = "/celebrity/{id}";
  public static final String MOVIE_MAPPING = "/movie/{id}";
  public static final String SHOW_MAPPING = "/show/{id}";
  public static final String SEASON_MAPPING = "/show/*/{seasonId}";
  public static final String EPISODE_MAPPING = "/show/*/*/{episodeId}";
  public static final String ADD_RATING_MAPPING = "/rating/{contentId}";
  public static final String GET_RATING_MAPPING = "/rating/search";

  public static final String PROFILE_MAPPING = "/profile/{userId}";

  public static final String USER_ID = "userId";
  public static final String DISPLAY_NAME = "displayName";
  public static final String EMAIL = "email";
  public static final String PASSWORD = "password";
  public static final String BODY = "body";
  public static final String SCORE = "score";
}
