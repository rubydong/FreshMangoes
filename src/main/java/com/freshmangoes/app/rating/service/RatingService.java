package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.user.data.userType;

public interface RatingService {
  boolean addToRating(Integer contentId,
                      Integer score,
                      userType type,
                      Integer reviewerId,
                      String body);
}
