package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.UserType;

public interface RatingService {
  boolean addToRating(Integer contentId,
                      Integer score,
                      UserType type,
                      Integer reviewerId,
                      String body);
}
