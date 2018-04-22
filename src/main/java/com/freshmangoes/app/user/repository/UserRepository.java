package com.freshmangoes.app.user.repository;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.user.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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


//  Boolean updateInterestedList(Integer userId, Integer contentId, Boolean present);
//
//  Boolean updateDisinterestedList(Integer userId, Integer contentId, Boolean present);
}