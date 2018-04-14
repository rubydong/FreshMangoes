package com.freshmangoes.app.common.data;

public class Constants {
  public static final String INDEX_MAPPING = "/index";
  public static final String LOGIN_MAPPING = "/login";
  public static final String LOGOUT_MAPPING = "/logout";
  public static final String REGISTER_MAPPING = "/register";
  public static final String CURRENT_USER_MAPPING = "/getCurrentUser";
  public static final String SEARCH_MAPPING = "/search";

  public static final String GET_CELEBRITY_MAPPING = "/celebrity/{id}";
  public static final String GET_ALL_CELEBRITY_MAPPING = "/celebrity/a/{id}";
  public static final String GET_ALL_CELEBRITY_BY_KEYWORD_MAPPING = "/celebrity/search";
  public static final String INSERT_CELEBRITY_MAPPING = "/celebrity/add";
  public static final String CHECK_CELEBRITY_EXISTS_MAPPING = "/celebrity/exists/{id}";
  public static final String DELETE_CELEBRITY_MAPPING = "/celebrity/delete/{id}";

  public static final String MOVIE_MAPPING = "/movie/{id}";
  public static final String SHOW_MAPPING = "/show/{id}";
  public static final String SEASON_MAPPING = "/show/*/{seasonId}";
  public static final String EPISODE_MAPPING = "/show/*/*/{episodeId}";

  public static final String ADD_RATING_MAPPING = "/rating/{contentId}";
  public static final String GET_RATING_BY_CONTENT_ID_MAPPING = "/rating/search/cid/{contentId}";
  public static final String GET_RATING_BY_REVIEWER_ID_MAPPING =  "/rating/search/rid/{reviewerId}";

  public static final String ADD_TO_INTERESTED_MAPPING = "interested/add/{contentId}";
  public static final String REMOVE_FROM_INTERESTED_MAPPING = "interested/remove/{contentId}";

  public static final String ADD_TO_DISINTERESTED_MAPPING = "disinterested/add/{contentId}";
  public static final String REMOVE_FROM_DISINTERESTED_MAPPING = "disinterested/remove/{contentId}";
  public static final String PROFILE_MAPPING = "/profile/{userId}";
  public static final String FOLLOW_MAPPING = "/follow/{userId}";
  public static final String UNFOLLOW_MAPPING = "/unfollow/{userId}";

  public static final String USER_ID = "userId";
  public static final String OTHER_USER_ID = "otherUserId";
  public static final String DISPLAY_NAME = "displayName";
  public static final String EMAIL = "email";
  public static final String PASSWORD = "password";
  public static final String BODY = "body";
  public static final String SCORE = "score";
}
