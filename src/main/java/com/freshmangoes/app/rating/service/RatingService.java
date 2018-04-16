package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import java.util.List;

public interface RatingService {
  boolean addRating(Rating rating);

  boolean editRating(Rating rating);

  void deleteRating(Integer id);

  List<Rating> getRatingByContentId(Integer contentId);

  List<Rating> getRatingByReviewerId(Integer reviewerId);
}
