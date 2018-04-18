package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.user.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByEmail(String email);

//  Boolean updateInterestedList(Integer userId, Integer contentId, Boolean present);
//
//  Boolean updateDisinterestedList(Integer userId, Integer contentId, Boolean present);
}