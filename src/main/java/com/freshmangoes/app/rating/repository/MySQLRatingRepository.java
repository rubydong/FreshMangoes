package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import org.springframework.stereotype.Repository;

@Repository
public class MySQLRatingRepository implements RatingRepository {
  public boolean insertRating(Rating rating) {
    return true;
  }
}
