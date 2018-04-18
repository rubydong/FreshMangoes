package com.freshmangoes.app.interested.service;

import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
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
    return null;
  }

  @Override
  public Boolean removeFromInterestedList(final Integer userId, final Integer contentId) {
    return null;
  }

  @Override
  public Boolean addToDisinterestedList(final Integer userId, final Integer contentId) {
    return null;
  }

  @Override
  public Boolean removeFromDisinterestedList(final Integer userId, final Integer contentId) {
    return null;
  }
}
