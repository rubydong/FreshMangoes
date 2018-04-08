package com.freshmangoes.app.follow;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.follow.service.FollowService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class FollowController {

  @Autowired
  private FollowService followService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.FOLLOW_MAPPING)
  public ResponseEntity follow(
      @RequestBody final Map<String, String> body, @PathVariable("userId") final Integer userId) {
    final HttpStatus status;

    boolean success = followService.followUser(
        Integer.parseInt(body.get(Constants.OTHER_USER_ID)), userId);
    if (success) {
      session.setAttribute(Constants.OTHER_USER_ID, userId);
      status = HttpStatus.OK;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.UNFOLLOW_MAPPING)
  public ResponseEntity unfollow(
      @RequestBody final Map<String, String> body, @PathVariable("userId") final Integer userId) {
    final HttpStatus status;

    boolean success = followService.unfollowUser(
        Integer.parseInt(body.get(Constants.OTHER_USER_ID)), userId);
    if (success) {
      session.setAttribute(Constants.OTHER_USER_ID, userId);
      status = HttpStatus.OK;
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }
}