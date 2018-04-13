package com.freshmangoes.app.user.service;

import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getUser(final Integer userId) {
    final User user = userRepository.findById(userId);
    if (user != null) {
      user.setHash(null);
    }
    return user;
  }
}
