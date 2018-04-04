package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.data.UserType;
import com.freshmangoes.app.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepository ratingRepository;

  public boolean addToRating(final Integer contentId,
                             final Integer score,
                             final UserType type,
                             final Integer reviewerId,
                             final String body) {
    return ratingRepository.insertRating(Rating
                                          .builder()
                                          .contentId(contentId)
                                          .score(score)
                                          .type(type)
                                          .reviewerId(reviewerId)
                                          .body(body)
                                          .build());
  }
}
