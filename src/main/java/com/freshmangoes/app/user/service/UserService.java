package com.freshmangoes.app.user.service;

import com.freshmangoes.app.user.data.User;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

public interface UserService {
  User getUser(Integer userId);

  User getUserByEmail(String email);

  void updatePassword(User user, String s1, String s);

  void updateEmail(User user, String s1, String s);

  Boolean forgotPassword(String email);

  void deleteAccount(User user, String s);

  Boolean updatePicture(User user, String s, MultipartFile file);

  void updateName(User user, String s1, String s);

  void updateViews(User user, BigInteger views);

  List<User> getCritics();

  Boolean applyForCritic(Integer userId, String statement);


  void updatePrivacy(User user, String s);
}
