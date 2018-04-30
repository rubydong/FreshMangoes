package com.freshmangoes.app.follow.service;

import com.freshmangoes.app.user.data.User;
import java.util.List;

public interface FollowService {
  Boolean followUser(Integer userId, Integer otherUserId);

  Boolean unfollowUser(Integer userId, Integer otherUserId);
}
