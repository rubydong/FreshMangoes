package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;

import java.util.List;

public interface RatingRepository {
  boolean insertRating(Rating rating);

  List<Rating> findByReviewerId(Integer reviewerId);

  List<Rating> findByContentId(Integer contentId);
}
