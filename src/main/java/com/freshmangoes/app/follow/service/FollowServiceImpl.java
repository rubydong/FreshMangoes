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
    if (userId.equals(otherUserId)) {
      return false;
    } else {
      return followRepository.save(userId, otherUserId);
    }
  }

  @Override
  public Boolean unfollowUser(final Integer userId, final Integer otherUserId) {
    if (userId.equals(otherUserId)) {
      return false;
    } else {
      return followRepository.delete(userId, otherUserId);
    }
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
