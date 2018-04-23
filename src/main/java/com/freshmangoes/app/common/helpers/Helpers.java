package com.freshmangoes.app.common.helpers;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import javax.servlet.http.HttpSession;

public class Helpers {
  public static User getAuthenticatedUser(HttpSession session) {
    User user = (User) session.getAttribute(Constants.USER_ID);
    return user;
  }
}
