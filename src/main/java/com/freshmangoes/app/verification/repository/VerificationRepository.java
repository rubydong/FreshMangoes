package com.freshmangoes.app.verification.repository;

import org.springframework.data.jpa.repository.Query;

public interface VerificationRepository {
  @Query(value = "DELETE FROM verification WHERE verification_key=?1", nativeQuery = true)
  void deleteByVerificationKey(String verificationKey);

  @Query(value = "SELECT (user_id) FROM verification WHERE verification_key=?1", nativeQuery = true)
  Integer findByVerificationKey(String verificationKey);

  @Query(value = "SELECT (verification_key) FROM verification WHERE user_id=?1", nativeQuery = true)
  String findByUserId(Integer userId);

  @Query(value = "INSERT INTO verification (user_id, verification_key) VALUES (?1, ?2)", nativeQuery = true)
  Boolean save(Integer userId, String verificationKey);
}
