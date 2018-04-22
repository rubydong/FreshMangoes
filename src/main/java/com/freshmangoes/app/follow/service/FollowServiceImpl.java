package com.freshmangoes.app.follow.service;

import com.freshmangoes.app.follow.repository.FollowRepository;
import com.freshmangoes.app.user.data.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {
  @Autowired
  private FollowRepository followRepository;

  @Override
  public Boolean followUser(final Integer userId, final Integer otherUserId) {
    if (userId.equals(otherUserId) || followRepository.isFollowing(userId, otherUserId) != null) {
      return false;
    }
    followRepository.saveFollowing(userId, otherUserId);
    return true;
  }

  @Override
  public Boolean unfollowUser(final Integer userId, final Integer otherUserId) {
    if (userId.equals(otherUserId)) {
      return false;
    }
    followRepository.deleteFollowing(userId, otherUserId);
    return true;
  }

  @Override
  public List<User> followers(final Integer id) {
    return followRepository.findAllFollowers(id);
  }

  @Override
  public List<User> following(final Integer id) {
    return followRepository.findAllFollowing(id);
  }
}
