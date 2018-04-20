package com.freshmangoes.app.user.service;

import com.freshmangoes.app.follow.repository.FollowRepository;
import com.freshmangoes.app.rating.repository.RatingRepository;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FollowRepository followRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Override
  public User getUser(final Integer userId) {
    final User user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      user.setHash(null);
      user.setNumFollowers(followRepository.countFollowers(userId));
      user.setNumFollowing(followRepository.countFollowing(userId));
      user.setInterestedList(userRepository.getInterestsByUserId(userId));
      user.setDisinterestedList(userRepository.getDisinterestsByUserId(userId));
      user.setRatings(ratingRepository.findByUserId(userId));
    }
    return user;
  }


}
