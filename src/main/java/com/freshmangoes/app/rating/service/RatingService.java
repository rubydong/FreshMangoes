package com.freshmangoes.app.rating.service;

import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.rating.data.Rating;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingService {
  Rating addRating(Integer contentId, ContentType contentType, Rating rating);

  Rating editRating(Integer userId, Rating rating);

  List<Rating> findByContentId(Integer contentId);

  List<Rating> findByUserId(Integer userId);

  void deleteRating(Integer userId, Integer ratingId);
}
