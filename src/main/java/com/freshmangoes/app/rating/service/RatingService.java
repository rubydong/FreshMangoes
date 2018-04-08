package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.userType;

import java.util.List;

public interface RatingService {
  boolean addToRating(Integer contentId,
                      Integer score,
                      userType type,
                      Integer reviewerId,
                      String body);

  List<Rating> getRatingByContentId(Integer contentId);

  List<Rating> getRatingByReviewerId(Integer reviewerId);
}
