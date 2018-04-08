package com.freshmangoes.app.follow.service;

public interface FollowService {
  boolean followUser(int userId, int otherUserId);
  boolean unfollowUser(int userId, int otherUserId);
}
