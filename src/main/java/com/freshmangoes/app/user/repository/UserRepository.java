package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.user.data.User;

public interface UserRepository {
  User findByEmail(String email);

  User findById(Integer id);

  User save(User user);

  Boolean updateInterestedList(Integer userId, Integer contentId, Boolean present);

  Boolean updateDisinterestedList(Integer userId, Integer contentId, Boolean present);
}