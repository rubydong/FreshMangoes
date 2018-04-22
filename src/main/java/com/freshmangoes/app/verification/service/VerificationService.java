package com.freshmangoes.app.verification.service;

import com.freshmangoes.app.user.data.User;

public interface VerificationService {
  Boolean sendVerificationEmail(User user);
  Boolean resendVerificationEmail(String email);
  User verifyUser(String verificationKey);
}
