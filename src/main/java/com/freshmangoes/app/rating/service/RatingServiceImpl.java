package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.repository.RatingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ShowRepository showRepository;

  public Rating addRating(final Integer contentId, final ContentType contentType, final Rating rating) {
    switch (contentType) {
      case MOVIE:
        rating.setContent(movieRepository.findById(contentId).orElse(null));
        break;
      case SHOW:
        rating.setContent(showRepository.findById(contentId).orElse(null));
        break;
    }
    return ratingRepository.existsByUserId(rating.getUser().getId(), contentId) == null
           ? ratingRepository.save(rating)
           : null;
  }

  public Rating editRating(final Integer userId, final Rating rating) {
    Rating existingRating = ratingRepository.findById(rating.getId()).orElse(null);
    if (existingRating == null) {
      return null;
    }
    existingRating.setBody(rating.getBody());
    existingRating.setScore(rating.getScore());
    ratingRepository.save(existingRating);
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
    if (rating == null || !rating.getUser().getId().equals(userId)) {
      return;
    }
    ratingRepository.deleteById(ratingId);
  }

  public Rating flagRating(final Integer ratingId, final String report) {
    Rating rating = ratingRepository.findById(ratingId).orElse(null);
    if (rating == null) {
      return null;
    }
    rating.setIsFlagged(true);
    ratingRepository.save(rating);
    return rating;
  }

  public List<Rating> getFlaggedRatings() {
    return ratingRepository.findFlaggedRatings();
  }
}
