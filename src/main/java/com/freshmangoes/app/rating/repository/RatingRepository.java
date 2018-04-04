package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;



public interface RatingRepository {
  boolean insertRating(final Rating rating);
}
