package com.freshmangoes.app.interested;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.interested.service.InterestsService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by romin on 4/8/18.
 */
public class InterestsController {

  @Autowired
  private InterestsService interestsService;

  @Autowired
  private HttpSession session;


  @PostMapping(Constants.ADD_TO_INTERESTED_MAPPING)
  public ResponseEntity addToInterestedList(@PathVariable final Integer contentId) {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final HttpStatus status;

    if (userId == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = interestsService.addToInterestedList(userId, contentId) ? HttpStatus.OK
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
      status = interestsService.removeFromInterestedList(userId, contentId) ? HttpStatus.OK
          : HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.ADD_TO_DISINTERESTED_MAPPING)
  public ResponseEntity addToDisinterestedList(@PathVariable final Integer contentId) {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final HttpStatus status;

    if (userId == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = interestsService.addToDisinterestedList(userId, contentId) ? HttpStatus.OK
                                                                          : HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }

  @PostMapping(Constants.REMOVE_FROM_INTERESTED_MAPPING)
  public ResponseEntity removeFromDisinterestedList(@PathVariable final Integer contentId) {
    final Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
    final HttpStatus status;

    if (userId == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = interestsService.removeFromDisinterestedList(userId, contentId) ? HttpStatus.OK
                                                                               : HttpStatus.BAD_REQUEST;
    }

    return new ResponseEntity(status);
  }
}
