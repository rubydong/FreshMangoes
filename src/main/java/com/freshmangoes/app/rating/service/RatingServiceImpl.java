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

  public Rating editRating(final Integer userId, final Rating rating) {
    Rating existingRating = ratingRepository.existsByUserId(userId);
    if (existingRating == null) {
      return null;
    }
    existingRating.setBody(rating.getBody());
    existingRating.setScore(rating.getScore());
    return existingRating;
  }

  public List<Rating> findByContentId(final Integer contentId) {
    return ratingRepository.findRatingByContentId(contentId);
  }

  public List<Rating> findByUserId(final Integer userId) {
    return ratingRepository.findByUserId(userId);
  }

  public void deleteRating(final Integer userId, final Integer ratingId) {
    Rating rating = ratingRepository.findById(ratingId).orElse(null);
    if (rating == null || !rating.getUserId().equals(userId)) {
      return;
    }
    ratingRepository.deleteById(ratingId);
  }
}
