package com.freshmangoes.app.user.service;

import com.freshmangoes.app.user.data.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {
  User getUser(Integer userId);

  void updatePassword(User user, String s);

  void updateEmail(User user, String s);

  boolean forgotPassword(String email);

  void deleteAccount(User user);

  void updatePicture();

  void updateName(User user, String s);

  void updateViews(User user, BigInteger views);

  List<User> getCritics();

  Boolean applyForCritic(Integer userId, String statement);
}
