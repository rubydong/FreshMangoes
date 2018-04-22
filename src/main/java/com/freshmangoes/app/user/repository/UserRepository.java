package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.user.data.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByEmail(String email);

  @Query(value = "SELECT c.* FROM Content c "
      + "JOIN Interests i on c.id = i.content_id and user_id = ?1", nativeQuery = true)
  List<Content> getInterestsByUserId(Integer userId);

  @Query(value = "SELECT c.* FROM Content c "
      + "JOIN Disinterests d on c.id = d.content_id and user_id = ?1", nativeQuery = true)
  List<Content> getDisinterestsByUserId(Integer userId);

  @Query(value = "SELECT (id) FROM Users WHERE verification_key=?1", nativeQuery = true)
  Integer findByVerificationKey(String verificationKey);

  @Query(value = "SELECT (verification_key) FROM Users WHERE id=?1", nativeQuery = true)
  String findByUserId(Integer userId);

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO interests (user_id, content_id) VALUES (?1, ?2)", nativeQuery = true)
  Integer addToInterestedList(Integer userId, Integer contentId);

  @Query(value = "SELECT user_id FROM interests WHERE user_id=?1 and content_id=?2", nativeQuery = true)
  Integer isInterestedInContent(Integer userId, Integer contentId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM interests WHERE user_id=?1 and content_id=?2", nativeQuery = true)
  void deleteFromInterestedList(Integer userId, Integer contentId);


//  Boolean updateInterestedList(Integer userId, Integer contentId, Boolean present);
//
//  Boolean updateDisinterestedList(Integer userId, Integer contentId, Boolean present);
}