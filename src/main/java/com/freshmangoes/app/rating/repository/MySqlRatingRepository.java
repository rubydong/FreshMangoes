package com.freshmangoes.app.rating.repository;

import com.freshmangoes.app.rating.data.Rating;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlRatingRepository implements RatingRepository {
  private Map<Integer, Rating> ratingMap;
  private int ratingCount;

  public MySqlRatingRepository() {
    ratingMap = new HashMap<>();
    ratingCount = 0;

    ratingMap.put(ratingCount, Rating.builder().id(ratingCount++).body("haha LOL").contentId(1337).reviewerId(90).build());
    ratingMap.put(ratingCount, Rating.builder().id(ratingCount++).body("haha LOL2").contentId(1337).reviewerId(91).build());
    ratingMap.put(ratingCount, Rating.builder().id(ratingCount++).body("haha LOL3").contentId(1337).reviewerId(92).build());
    ratingMap.put(ratingCount, Rating.builder().id(ratingCount++).body("haha LOL4").contentId(1337).reviewerId(90).build());
  }

  public boolean insertRating(final Rating rating) {
    rating.setId(ratingCount++);
    ratingMap.put(rating.getId(), rating);
    return true;
  }

  public List<Rating> findByReviewerId(final Integer reviewerId) {
    return ratingMap.values().stream()
     .filter(r -> r.getReviewerId().equals(reviewerId))
     .collect(Collectors.toList());
  }

  public List<Rating> findByContentId(final Integer contentId) {
    return ratingMap.values().stream()
     .filter(r -> r.getContentId().equals(contentId))
     .collect(Collectors.toList());
  }
}
