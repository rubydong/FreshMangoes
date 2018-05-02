package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.user.data.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByEmail(String email);

  @Query(value = "SELECT c.* FROM Content c "
      + "JOIN Interests i on c.id = i.content_id and user_id = ?1", nativeQuery = true)
  List<Content> getInterestsByUserId(Integer userId);

  @Query(value = "SELECT c.* FROM Content c "
      + "JOIN Disinterests d on c.id = d.content_id and user_id = ?1", nativeQuery = true)
  List<Content> getDisinterestsByUserId(Integer userId);

  User findByVerificationKey(String verificationKey);

  Optional<User> findById(Integer id);

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

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO disinterests (user_id, content_id) VALUES (?1, ?2)", nativeQuery = true)
  Integer addToDisinterestedList(Integer userId, Integer contentId);

  @Query(value = "SELECT user_id FROM disinterests WHERE user_id=?1 and content_id=?2", nativeQuery = true)
  Integer isDisinterestedInContent(Integer userId, Integer contentId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM disinterests WHERE user_id=?1 and content_id=?2", nativeQuery = true)
  void deleteFromDisinterestedList(Integer userId, Integer contentId);

  @Query(value = "SELECT * FROM users WHERE user_type=1", nativeQuery = true)
  List<User> getAllCritics();

  @Transactional
  @Modifying
  @Query(value = "INSERT into critic_application (user_id, statement) VALUES (?1, ?2)", nativeQuery = true)
  Integer applyForCritic(Integer userId, String statement);

  @Query(value = "SELECT user_id FROM critic_application WHERE user_id=?1", nativeQuery = true)
  Integer appliedForCritic(Integer userId);

  @Query(value = "SELECT * FROM users u,critic_application c WHERE u.id=c.user_id", nativeQuery = true)
  List<User> getAllPotentialCritics();

  @Query(value = "SELECT statement FROM critic_application WHERE user_id=?1", nativeQuery = true)
  String getCriticApplicationStatement(Integer userId);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM critic_application WHERE user_id=?1", nativeQuery = true)
  void deleteCriticApplication(Integer userId);
}
