package com.freshmangoes.app.verification.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlVerificationRepository implements VerificationRepository {
  @Override
  public void deleteByVerificationKey(String verificationKey) {

  }

  @Override
  public Integer findByVerificationKey(String verificationKey) {
    return null;
  }

  @Override
  public String findByUserId(Integer userId) {
    return null;
  }

  @Override
  public Boolean save(Integer userId, String verificationKey) {
    return null;
  }
}