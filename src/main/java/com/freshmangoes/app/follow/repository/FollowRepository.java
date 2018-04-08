package com.freshmangoes.app.follow.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository {
  public boolean save(int userId, int otherUserId);
  public boolean delete(int userId, int otherUserId);
}
