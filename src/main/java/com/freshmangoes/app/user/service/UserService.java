package com.freshmangoes.app.user.service;

import com.freshmangoes.app.user.data.User;

public interface UserService {

  Integer loginUser(String username, String password);

  Integer registerUser(String displayName, String email, String password);

  User getUser(Integer userId);
}