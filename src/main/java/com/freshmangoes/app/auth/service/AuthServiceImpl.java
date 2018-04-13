package com.freshmangoes.app.auth.service;

import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Integer loginUser(final String email, final String password) {
    final User user = userRepository.findByEmail(email);
    if (user == null) {
      return null;
    } else {
      final String hash = user.getHash();
      return passwordEncoder.matches(password, hash) ? user.getId() : null;
    }
  }

  @Override
  public Integer registerUser(final String email, final String password, final String displayName) {
    final String hash = passwordEncoder.encode(password);
    final User user = User.builder()
        .email(email)
        .hash(hash)
        .displayName(displayName)
        .build();
    return userRepository.save(user).getId();
  }

}
