package com.freshmangoes.app.follow.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLFollowRepository implements FollowRepository {
  public boolean save(int userId, int otherUserId) { return true; }
  public boolean delete(int userId, int otherUserId) {
    return true;
  }
}
