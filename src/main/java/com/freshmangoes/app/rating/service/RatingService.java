package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.UserType;



public interface RatingService {
  boolean addToRating(final Integer contentId,
                      final Integer score,
                      final UserType type,
                      final Integer reviewerId,
                      final String body);
}
