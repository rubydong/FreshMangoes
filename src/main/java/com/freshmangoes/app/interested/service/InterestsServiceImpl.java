package com.freshmangoes.app.interested.service;

import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestsServiceImpl implements InterestsService {

  @Autowired
  private MovieRepository mySQLMovieRepository;

  @Autowired
  private ShowRepository mySQLShowRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Boolean addToInterestedList(final Integer userId, final Integer contentId) {
    if (!mySQLMovieRepository.existsById(contentId)) {
      return false;
    } else {
      return userRepository.updateInterestedList(userId, contentId, true);
    }
  }

  @Override
  public Boolean removeFromInterestedList(final Integer userId, final Integer contentId) {
    return userRepository.updateInterestedList(userId, contentId, false);
  }

  @Override
  public Boolean addToDisinterestedList(final Integer userId, final Integer contentId) {
    if (!mySQLMovieRepository.existsById(contentId)) {
      return false;
    } else {
      return userRepository.updateDisinterestedList(userId, contentId, true);
    }
  }

  @Override
  public Boolean removeFromDisinterestedList(final Integer userId, final Integer contentId) {
    return userRepository.updateDisinterestedList(userId, contentId, false);
  }
}
