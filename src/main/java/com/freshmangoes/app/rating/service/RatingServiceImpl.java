package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepository ratingRepository;

  public Rating addRating(final Rating rating) {
    return ratingRepository.existsByUserId(rating.getUserId()) == null
           ? ratingRepository.save(rating)
           : null;
  }

//  public List<Rating> findByUserId(final Integer reviewerId) {
//    return ratingRepository.findByUserId(reviewerId);
//  }

}
