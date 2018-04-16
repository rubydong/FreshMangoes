package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;

import java.util.List;

public interface RatingService {
  boolean addToRating(Integer contentId,
                      Integer score,
                      UserType type,
                      Integer reviewerId,
                      String username,
                      String body);

  boolean editRating(Integer ratingId,
                     Integer score,
                     String body);

  void deleteRating(Integer id);

  List<Rating> getRatingByContentId(Integer contentId);

  List<Rating> getRatingByReviewerId(Integer reviewerId);
}
