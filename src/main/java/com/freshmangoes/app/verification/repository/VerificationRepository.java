package com.freshmangoes.app.verification.repository;

public interface VerificationRepository {
  void deleteByVerificationKey(String verificationKey);
  Integer findByVerificationKey(String verificationKey);
  String findByUserId(Integer userId);
  Boolean save(Integer userId, String verificationKey);
}
