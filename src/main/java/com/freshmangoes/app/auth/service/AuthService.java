package com.freshmangoes.app.auth.service;

public interface AuthService {
  Integer loginUser(String username, String password);

  Integer registerUser(String displayName, String email, String password);
}
