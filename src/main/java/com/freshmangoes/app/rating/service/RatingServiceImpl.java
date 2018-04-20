package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.UserType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepository ratingRepository;

  public List<Rating> findByContentId(Integer contentId) {
    return ratingRepository.findByContentId(contentId);
  }

//  public List<Rating> findByUserId(final Integer reviewerId) {
//    return ratingRepository.findByUserId(reviewerId);
//  }

}
