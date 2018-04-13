package com.freshmangoes.app.follow.service;

import com.freshmangoes.app.follow.repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
  @Autowired
  private FollowRepository followRepository;

  @Override
  public boolean followUser(int userId, int otherUserId) {
    return followRepository.save(userId, otherUserId);
  }

  @Override
  public boolean unfollowUser(int userId, int otherUserId) {
    return followRepository.delete(userId, otherUserId);
  }
}
