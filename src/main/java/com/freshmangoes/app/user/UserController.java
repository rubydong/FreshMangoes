package com.freshmangoes.app.user;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private HttpSession session;

  @GetMapping(Constants.PROFILE_MAPPING)
  public User getProfile(@PathVariable final int userId) {
    return  userService.getUser(userId);
  }

  @PostMapping(Constants.ADD_TO_INTERESTED_MAPPING)
  public ResponseEntity addToInterestedList(@PathVariable final Integer contentId) {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final HttpStatus status;

    if (userId == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = userService.addToInterestedList(userId, contentId) ? HttpStatus.OK
                                                                  : HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.REMOVE_FROM_INTERESTED_MAPPING)
  public ResponseEntity removeFromInterestedList(@PathVariable final Integer contentId) {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final HttpStatus status;

    if (userId == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = userService.removeFromInterestedList(userId, contentId) ? HttpStatus.OK
                                                                       : HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }
}
