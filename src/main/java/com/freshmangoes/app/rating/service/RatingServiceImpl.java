package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.content.data.ContentType;
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

  public boolean addToRating(final Integer contentId,
                             final Integer score,
                             final UserType type,
                             final Integer reviewerId,
                             final String username,
                             final String body) {
    return ratingRepository.insertRating(Rating
                                          .builder()
                                          .contentId(contentId)
                                          .contentType(ContentType.MOVIE)
                                          .score(score)
                                          .userType(type)
                                          .reviewerId(reviewerId)
                                          .username(username)
                                          .body(body)
                                          .build());
  }

  public boolean editRating(final Integer ratingId,
                            final Integer score,
                            final String body) {
    return ratingRepository.editRating(ratingId,
                                       score,
                                       body);
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
