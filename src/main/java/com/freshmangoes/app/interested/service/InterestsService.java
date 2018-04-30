package com.freshmangoes.app.interested.service;

public interface InterestsService {
  Boolean addToInterestedList(Integer userId, Integer contentId);

  void removeFromInterestedList(Integer userId, Integer contentId);

  Boolean addToDisinterestedList(Integer userId, Integer contentId);

  void removeFromDisinterestedList(Integer userId, Integer contentId);
}
