package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlRatingRepository implements RatingRepository {
  public boolean insertRating(final Rating rating) {
    return true;
  }
}