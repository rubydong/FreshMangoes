package com.freshmangoes.app.interested.service;

public interface InterestsService {
  Boolean addToInterestedList(Integer userId, Integer contentId);

  Boolean removeFromInterestedList(Integer userId, Integer contentId);

  Boolean addToDisinterestedList(Integer userId, Integer contentId);

  Boolean removeFromDisinterestedList(Integer userId, Integer contentId);
}
