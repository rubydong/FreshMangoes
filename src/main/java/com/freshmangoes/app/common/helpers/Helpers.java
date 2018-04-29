package com.freshmangoes.app.common.helpers;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.user.data.User;
import javax.servlet.http.HttpSession;

public class Helpers {
  public static User getAuthenticatedUser(HttpSession session) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    return user;
  }

  public static ContentType stringToContentType(String type) {
    switch (type) {
      case "MOVIE":
        return ContentType.MOVIE;
      case "SHOW":
        return ContentType.SHOW;
      case "EPISODE":
        return ContentType.EPISODE;
      case "SEASON":
        return ContentType.SEASON;
    }
    return null;
  }
}
