package com.freshmangoes.app.verification.service;

import com.freshmangoes.app.email.service.EmailService;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {
  @Autowired
  private EmailService emailService;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Boolean sendVerificationEmail(String email, Integer userId) {
    final String verificationKey = UUID.randomUUID().toString();
    final User user = userRepository.findById(userId).get();
    user.setVerificationKey(verificationKey);
    userRepository.save(user);
    emailService.sendEmail(email, "Fresh Mangoes Verification", "Click this link to"
        + "verify yourself please: http://localhost:9000/verify/" + verificationKey);
    return true;
  }

  @Override
  public Boolean resendVerificationEmail(String email) {
    final User user = userRepository.findByEmail(email);
    final String verificationKey = userRepository.findByUserId(user.getId());

    if (verificationKey != null) {
      emailService.sendEmail(email, "Fresh Mangoes Verification Resend", "Click this link to"
          + "verify yourself please: http://localhost:9000/verify/" + verificationKey);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public User verifyUser(String verificationKey) {
    final User user;
    final Integer userId;

    userId = userRepository.findByVerificationKey(verificationKey);

    if (userId != null) {
      user = userRepository.findById(userId).get();
      user.setVerified(true);
      userRepository.save(user);
      return user;
    } else {
      return null;
    }
  }
}
