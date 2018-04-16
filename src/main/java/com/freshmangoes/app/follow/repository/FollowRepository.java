package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository {
  Boolean save(Integer userId, Integer otherUserId);

  Boolean delete(Integer userId, Integer otherUserId);

  List<User> findAllFollowing(Integer id);

  List<User> findAllFollowers(Integer id);
}
