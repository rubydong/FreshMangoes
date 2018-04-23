package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<User, Integer> {

  @Transactional
  @Modifying
  @Query(value = "INSERT into Following (followee_id, follower_id) VALUES (?2, ?1)", nativeQuery = true)
  void saveFollowing(Integer followerId, Integer followeeId);

  @Query(value = "SELECT followee_id FROM Following WHERE followee_id=?2 AND follower_id=?1", nativeQuery = true)
  Integer isFollowing(Integer followerId, Integer followeeId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM Following WHERE followee_id=?2 AND follower_id=?1", nativeQuery = true)
  void deleteFollowing(Integer followerId, Integer followeeId);

  @Query(value = "SELECT COUNT(*) AS Num_Followers FROM Following WHERE followee_id = ?1", nativeQuery = true)
  Integer countFollowers(Integer userId);

  @Query(value = "SELECT COUNT(*) AS Num_Following FROM Following WHERE follower_id = ?1", nativeQuery = true)
  Integer countFollowing(Integer userId);

}
