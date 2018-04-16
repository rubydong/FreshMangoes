package com.freshmangoes.app.auth.service;

import com.freshmangoes.app.user.data.User;

public interface AuthService {
  User loginUser(String username, String password);

  Integer registerUser(String displayName, String email, String password);

}
