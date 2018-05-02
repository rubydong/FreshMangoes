package com.freshmangoes.app.interested;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.interested.service.InterestsService;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterestsController {

  @Autowired
  private InterestsService interestsService;

  @Autowired
  private UserService userService;

  @Autowired
  private HttpSession session;


  @PostMapping(Constants.ADD_TO_INTERESTED_MAPPING)
  public ResponseEntity addToInterestedList(@PathVariable final Integer contentId) {
    final HttpStatus status;
    final Integer userId = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user != null) {
      status = interestsService.addToInterestedList(user.getId(), contentId) ? HttpStatus.OK
          : HttpStatus.BAD_REQUEST;
      interestsService.removeFromDisinterestedList(user.getId(), contentId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.REMOVE_FROM_INTERESTED_MAPPING)
  public ResponseEntity removeFromInterestedList(@PathVariable final Integer contentId) {
    final HttpStatus status;
    final Integer userId = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user != null) {
      status = HttpStatus.OK;
      interestsService.removeFromInterestedList(user.getId(), contentId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.ADD_TO_DISINTERESTED_MAPPING)
  public ResponseEntity addToDisinterestedList(@PathVariable final Integer contentId) {
    final HttpStatus status;
    final Integer userId = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user != null) {
      status = interestsService.addToDisinterestedList(user.getId(), contentId) ? HttpStatus.OK
          : HttpStatus.BAD_REQUEST;
      interestsService.removeFromInterestedList(user.getId(), contentId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.REMOVE_FROM_DISINTERESTED_MAPPING)
  public ResponseEntity removeFromDisinterestedList(@PathVariable final Integer contentId) {
    final HttpStatus status;
    final Integer userId = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user != null) {
      status = HttpStatus.OK;
      interestsService.removeFromDisinterestedList(user.getId(), contentId);
    } else {
      status = HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }
}
