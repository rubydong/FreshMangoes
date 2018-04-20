package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;

import java.util.List;

public interface RatingService {
  List<Rating> findByContentId(Integer contentId);

  Rating addRating(Rating rating);


//  List<Rating> findByUserId(Integer reviewerId);
}
