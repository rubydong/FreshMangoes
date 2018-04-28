package com.freshmangoes.app.user.service;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.email.service.EmailService;
import com.freshmangoes.app.follow.repository.FollowRepository;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FollowRepository followRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private EmailService emailService;

  @Override
  public User getUser(final Integer userId) {
    final User user = userRepository.findById(userId).orElse(null);
    user.setRatings(ratingRepository.findByUserId(userId));
    return user;
  }

  @Override
  public void updatePassword(User user, String s) {
    String hash = passwordEncoder.encode(s);
    user.setHash(hash);
    userRepository.save(user);
  }

  @Override
  public void updateEmail(User user, String email) {
    user.setEmail(email);
    userRepository.save(user);
  }

  @Override
  public boolean forgotPassword(String email) {
    return emailService.sendEmail(email, "Fresh Mangoes Password Reset",
        "Click this link to reset your password: http://localhost:9000/resetpassword/");
  }

  @Override
  public void deleteAccount(User user) {
    userRepository.delete(user);
  }

  @Override
  public void updatePicture() {

  }

  @Override
  public void updateName(User user, String name) {
    user.setDisplayName(name);
    userRepository.save(user);
  }

  public List<User> getCritics() {
    return userRepository.getAllCritics();
  }

}
