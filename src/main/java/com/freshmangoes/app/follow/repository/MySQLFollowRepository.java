package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MySQLFollowRepository implements FollowRepository {

  @Autowired
  private UserRepository userRepository;
  private Map<String, User> userMap;

  public boolean save(int userId, int otherUserId) {
    User first = userRepository.findById(userId);
    User second = userRepository.findById(otherUserId);
    first.setNumFollowing(first.getNumFollowing() + 1);
    second.setNumFollowers(second.getNumFollowers() + 1);
    return true;
  }

  public boolean delete(int userId, int otherUserId) {
    User first = userRepository.findById(userId);
    User second = userRepository.findById(otherUserId);
    first.setNumFollowing(first.getNumFollowing() - 1);
    second.setNumFollowers(second.getNumFollowers() - 1);
    return true;
  }
}
