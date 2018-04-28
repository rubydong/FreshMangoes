package com.freshmangoes.app.common.data;

public class Constants {
  public static final String INDEX_MAPPING = "/index";
  public static final String LOGIN_MAPPING = "/login";
  public static final String LOGOUT_MAPPING = "/logout";
  public static final String REGISTER_MAPPING = "/register";
  public static final String VERIFY_MAPPING = "/verify/{verificationKey}";
  public static final String RESEND_MAPPING = "/resendverification";
  public static final String CURRENT_USER_MAPPING = "/getCurrentUser";
  public static final String SEARCH_MAPPING = "/search";
  public static final String SPOTLIGHT_MAPPING = "/spotlightItems";

  public static final String GET_CELEBRITY_MAPPING = "/celebrity/{id}";
  public static final String GET_ALL_CELEBRITY_MAPPING = "/celebrity/all/{id}";
  public static final String GET_ALL_CELEBRITY_BY_KEYWORD_MAPPING = "/celebrity/search";
  public static final String INSERT_CELEBRITY_MAPPING = "/celebrity/add";
  public static final String DELETE_CELEBRITY_MAPPING = "/celebrity/delete/{id}";

  public static final String MOVIE_MAPPING = "/movie/{id}";
  public static final String SHOW_MAPPING = "/show/{id}";
  public static final String SEASON_MAPPING = "/show/{showId}/season/{seasonId}";
  public static final String EPISODE_MAPPING = "/show/{showId}/season/{seasonId}/episode/{episodeId}";

  public static final String ADD_RATING_MAPPING = "/rating/{contentId}";
  public static final String EDIT_RATING_MAPPING = "/rating/update/{ratingId}";
  public static final String DELETE_RATING_MAPPING = "/rating/delete/{id}";
  public static final String FLAG_RATING_MAPPING = "/rating/flag/{ratingId}";
  public static final String GET_RATING_BY_CONTENT_ID_MAPPING = "/rating/search/cid/{contentId}";
  public static final String GET_RATING_BY_USER_ID_MAPPING = "/rating/search/uid/{userId}";
  public static final String GET_LATEST_RATINGS = "/rating/latest";

  public static final String ADD_TO_INTERESTED_MAPPING = "/interested/add/{contentId}";
  public static final String REMOVE_FROM_INTERESTED_MAPPING = "/interested/remove/{contentId}";

  public static final String ADD_TO_DISINTERESTED_MAPPING = "/disinterested/add/{contentId}";
  public static final String REMOVE_FROM_DISINTERESTED_MAPPING =
      "/disinterested/remove/{contentId}";

  public static final String DELETE_ACCOUNT_MAPPING = "/delete/profile";
  public static final String PROFILE_MAPPING = "/profile/{userId}";
  public static final String GET_ALL_CRITICS = "/critics";
  public static final String FOLLOW_MAPPING = "/follow/{userId}";
  public static final String UNFOLLOW_MAPPING = "/unfollow/{userId}";
  public static final String GET_FOLLOWERS_MAPPING = "/followers/{userId}";
  public static final String GET_FOLLOWING_MAPPING = "/following/{userId}";
  public static final String CHANGE_PASSWORD_MAPPING = "/profile/password/reset";
  public static final String CHANGE_PICTURE_MAPPING = "/profile/picture/update";
  public static final String CHANGE_NAME_MAPPING = "/profile/name/update";
  public static final String CHANGE_EMAIL_MAPPING = "/profile/email/reset";
  public static final String FORGOT_PASSWORD_MAPPING = "/forgotpassword";
  public static final String RESET_PASSWORD_MAPPING = "/resetpassword/{userId}";


  public static final String ADMIN_ADD_DETAIL_PAGE_MAPPING = "/admin/content/insert";
  public static final String ADMIN_UPDATE_DETAIL_PAGE_MAPPING = "/admin/update";
  public static final String ADMIN_DELETE_DETAIL_PAGE_MAPPING = "/admin/delete/{contentId}";
  public static final String ADMIN_VIEW_REPORTS_MAPPING = "/admin/reports";
  public static final String ADMIN_DELETE_RATING_MAPPING = "/admin/rating/delete/{ratingId}";
  public static final String ADMIN_DELETE_USER_MAPPING = "/admin/user/delete/{userId}";
  public static final String ADMIN_REINDEX_MAPPING = "/admin/reindex";
  public static final String ADMIN_APPROVE_CRITIC = "/admin/approve/{userId}";

  public static final String APPLICATION_JSON = "application/json";

  public static final String USER_ID = "userId";
  public static final String USER_TYPE = "userType";
  public static final String OTHER_USER_ID = "otherUserId";
  public static final String DISPLAY_NAME = "displayName";
  public static final String EMAIL = "email";
  public static final String PASSWORD = "password";
  public static final String BODY = "body";
  public static final String SCORE = "score";

  public static final String NEW_NAME = "newName";
  public static final String NEW_PASSWORD = "newPassword";
  public static final String OLD_PASSWORD = "oldPassword";
  public static final String NEW_EMAIL = "newEmail";
  public static final String NEW_PROFILE = "newFile";

  public static final Integer NUM_LATEST_REVIEWS = 10;

}
