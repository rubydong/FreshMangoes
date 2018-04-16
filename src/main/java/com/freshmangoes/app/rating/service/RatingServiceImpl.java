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

  public boolean addRating(final Rating rating) {
    return ratingRepository.insertRating(rating);
  }

  public boolean editRating(final Rating rating) {
    return ratingRepository.editRating(rating);
  }

  public List<Rating> getRatingByContentId(final Integer contentId) {
    return ratingRepository.findByContentId(contentId);
  }

  public List<Rating> getRatingByReviewerId(final Integer reviewerId) {
    return ratingRepository.findByReviewerId(reviewerId);
  }

  public void deleteRating(final Integer id) {
    ratingRepository.deleteRating(id);
  }
}
