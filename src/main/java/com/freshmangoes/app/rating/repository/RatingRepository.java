package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
  @Query(value = "SELECT * FROM ratings WHERE content_id = ?1 ORDER BY `id` DESC", nativeQuery = true)
  List<Rating> findRatingByContentId(Integer contentId);

  @Query(value = "SELECT 1 FROM ratings WHERE user_id = ?1 and content_id=?2", nativeQuery = true)
  Rating existsByUserId(Integer userId, Integer contentId);

  @Query(value = "SELECT * FROM ratings WHERE user_id = ?1 ORDER BY `id` DESC", nativeQuery = true)
  List<Rating> findByUserId(Integer id);

  @Query(value = "SELECT * FROM ratings WHERE flagged=true", nativeQuery = true)
  List<Rating> findFlaggedRatings();

  @Query(value = "SELECT * FROM ratings WHERE ratings.user_id in (SELECT id from users where users.user_type=1) ORDER BY id DESC LIMIT ?1", nativeQuery = true)
  List<Rating> findLatestRatings(Integer numRatings);
}
