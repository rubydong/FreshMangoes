package com.freshmangoes.app.verification.service;

import com.freshmangoes.app.email.service.EmailService;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import com.freshmangoes.app.verification.repository.VerificationRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {
  @Autowired
  private EmailService emailService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private VerificationRepository verificationRepository;

  @Override
  public Boolean sendVerificationEmail(String email, Integer userId) {
    final String verificationKey = UUID.randomUUID().toString();
    if (verificationRepository.save(userId, verificationKey)) {
      emailService.sendEmail(email, "", "");
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Boolean resendVerificationEmail(String email) {
    final User user = userRepository.findByEmail(email);
    final String verificationKey = verificationRepository.findByUserId(user.getId());

    if (verificationKey != null) {
      emailService.sendEmail(email, "", "");
      return true;
    } else {
      return false;
    }
  }

  @Override
  public User verifyUser(String verificationKey) {
    final User user;
    final Integer userId;

    userId = verificationRepository.findByVerificationKey(verificationKey);

    if (userId != null) {
      user = userRepository.findById(userId);
      user.setVerified(true);
      userRepository.save(user);
      verificationRepository.deleteByVerificationKey(verificationKey);
      user.setHash(null);
      return user;
    } else {
      return null;
    }
  }
}
