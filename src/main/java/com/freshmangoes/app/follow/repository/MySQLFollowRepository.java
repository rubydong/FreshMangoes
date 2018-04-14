package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MySQLFollowRepository implements FollowRepository {

  @Autowired
  private UserRepository userRepository;
  private Map<String, User> userMap;

  @Override
  public Boolean save(Integer userId, Integer otherUserId) {
    User first = userRepository.findById(userId);
    User second = userRepository.findById(otherUserId);
    first.setNumFollowing(first.getNumFollowing() + 1);
    second.setNumFollowers(second.getNumFollowers() + 1);
    return true;
  }

  @Override
  public Boolean delete(Integer userId, Integer otherUserId) {
    User first = userRepository.findById(userId);
    User second = userRepository.findById(otherUserId);
    first.setNumFollowing(first.getNumFollowing() - 1);
    second.setNumFollowers(second.getNumFollowers() - 1);
    return true;
  }

  @Override
  public List<User> findAllFollowing(final Integer id) {
    return null;
  }

  @Override
  public List<User> findAllFollowers(final Integer id) {
    return null;
  }
}
