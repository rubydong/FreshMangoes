package com.freshmangoes.app.follow.repository;

import com.freshmangoes.app.user.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<User, Integer> {

  @Query(value = "INSERT into Followings (followee_id, follower_id) VALUES (?2, ?1)", nativeQuery = true)
  void saveFollowing(Integer followerId, Integer followeeId);

  @Query(value = "DELETE FROM Followings WHERE followee_id=?2 AND followerId=?1", nativeQuery = true)
  void deleteFollowing(Integer followerId, Integer followeeeId);

  @Query(value = "SELECT u.display_name, u.profile_picture, u.id FROM Users u"
          + "JOIN Followings f WHERE f.follower_id = ?1", nativeQuery = true)
  List<User> findAllFollowing(Integer id);

  @Query(value = "SELECT u.display_name, u.profile_picture, u.id FROM Users u"
          + "JOIN Followings f WHERE f.followee_id = ?1", nativeQuery = true)
  List<User> findAllFollowers(Integer id);
}
