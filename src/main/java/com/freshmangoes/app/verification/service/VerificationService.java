package com.freshmangoes.app.verification.service;

import com.freshmangoes.app.user.data.User;

public interface VerificationService {
  Boolean sendVerificationEmail(String email, Integer userId);
  Boolean resendVerificationEmail(String email);
  User verifyUser(String verificationKey);
}
