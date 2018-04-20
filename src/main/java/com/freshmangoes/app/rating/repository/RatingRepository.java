package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
  @Query(value = "SELECT * FROM Ratings WHERE content_id = ?1", nativeQuery = true)
  List<Rating> findRatingByContentId(Integer contentId);

  @Query(value = "SELECT 1 FROM Ratings WHERE user_id = ?1", nativeQuery = true)
  Rating existsByUserId(Integer userId);

  @Query(value = "SELECT * FROM Ratings WHERE user_id = ?1", nativeQuery = true)
  List<Rating> findByUserId(Integer id);
}
