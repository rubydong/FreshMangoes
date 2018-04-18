package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
//  boolean insertRating(Rating rating);
//
//  boolean editRating(Integer ratingId,
//                     Integer score,
//                     String body);
//
//  void deleteRating(Integer id);
//
//  List<Rating> findByReviewerId(Integer reviewerId);
//
//  List<Rating> findByContentId(Integer contentId);
}
