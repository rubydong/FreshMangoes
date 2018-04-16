package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;

import java.util.List;

public interface RatingRepository {
  boolean insertRating(Rating rating);

  boolean editRating(Integer ratingId,
                     Integer score,
                     String body);

  void deleteRating(Integer id);

  List<Rating> findByReviewerId(Integer reviewerId);

  List<Rating> findByContentId(Integer contentId);
}
