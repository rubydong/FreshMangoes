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
  public Boolean sendVerificationEmail(final User user) {
    final String verificationKey = UUID.randomUUID().toString();
    user.setVerificationKey(verificationKey);
    userRepository.save(user);
    return emailService.sendEmail(user.getEmail(), "Fresh Mangoes Verification", "Click this link to"
        + "verify yourself please: http://localhost:9000/verify/" + verificationKey);
  }

  @Override
  public Boolean resendVerificationEmail(String email) {
    final User user = userRepository.findByEmail(email);

    if (user != null) {
      return emailService.sendEmail(email, "Fresh Mangoes Verification Resend", "Click this link to"
          + "verify yourself please: http://localhost:9000/verify/" + user.getVerificationKey());
    } else {
      return false;
    }
  }

  @Override
  public User verifyUser(String verificationKey) {
    final User user;
    final Integer userId;

    user = userRepository.findByVerificationKey(verificationKey);

    if (user != null) {
      user.setVerified(true);
      userRepository.save(user);
      return user;
    } else {
      return null;
    }
  }
}
