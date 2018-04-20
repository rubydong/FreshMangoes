package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends CrudRepository<User, Integer> {
//  Boolean save(Integer userId, Integer otherUserId);
//
//  Boolean delete(Integer userId, Integer otherUserId);

//  List<User> findAllFollowing(Integer id);
//
//  List<User> findAllFollowers(Integer id);
}
