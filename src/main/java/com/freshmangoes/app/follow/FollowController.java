package com.freshmangoes.app.follow;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.follow.service.FollowService;
import com.freshmangoes.app.user.data.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class FollowController {
  @Autowired
  private FollowService followService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.FOLLOW_MAPPING)
  public ResponseEntity follow(@PathVariable final Integer userId) {
    final HttpStatus status;
    final User user = Helpers.getAuthenticatedUser(session);

    if (user != null) {
      status = followService.followUser(user.getId(), userId) ? HttpStatus.OK
                                                              : HttpStatus.BAD_REQUEST;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.UNFOLLOW_MAPPING)
  public ResponseEntity unfollow(@PathVariable final Integer userId) {
    final HttpStatus status;
    final User user = Helpers.getAuthenticatedUser(session);

    if (user != null) {
      status = followService.unfollowUser(user.getId(), userId) ? HttpStatus.OK
                                                                : HttpStatus.BAD_REQUEST;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @GetMapping(Constants.GET_FOLLOWERS_MAPPING)
  public List<User> getFollowers(@PathVariable final Integer userId) {
    return followService.followers(userId);
  }

  @GetMapping(Constants.GET_FOLLOWING_MAPPING)
  public List<User> getFollowing(@PathVariable final Integer userId) {
    return followService.following(userId);
  }
}