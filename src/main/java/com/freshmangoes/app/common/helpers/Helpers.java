package com.freshmangoes.app.common.helpers;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.user.data.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

public class Helpers {

  public static Integer getAuthenticatedUser(HttpSession session) {
    return (Integer) session.getAttribute(Constants.USER_ID);
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
