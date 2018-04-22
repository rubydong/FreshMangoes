package com.freshmangoes.app.interested.service;

import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestsServiceImpl implements InterestsService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Boolean addToInterestedList(final Integer userId, final Integer contentId) {
    if (userRepository.isInterestedInContent(userId, contentId) == null) {
      return userRepository.addToInterestedList(userId, contentId) == 1;
    } else {
      return false;
    }
  }

  @Override
  public void removeFromInterestedList(final Integer userId, final Integer contentId) {
    userRepository.deleteFromInterestedList(userId, contentId);
  }

  @Override
  public Boolean addToDisinterestedList(final Integer userId, final Integer contentId) {
    return null;
  }

  @Override
  public void removeFromDisinterestedList(final Integer userId, final Integer contentId) {
    return;
  }
}
