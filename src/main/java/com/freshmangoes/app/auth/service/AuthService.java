package com.freshmangoes.app.auth.service;

import com.freshmangoes.app.user.data.User;
import javax.servlet.http.HttpSession;

public interface AuthService {
  User loginUser(String username, String password);

  Integer registerUser(String displayName, String email, String password);

}
