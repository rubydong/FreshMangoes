package com.freshmangoes.app.rating;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.service.RatingService;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.ADD_RATING_MAPPING)
  public ResponseEntity addRating(@RequestBody final Map<String, String> body,
                                  @PathVariable final Integer contentId) {
    final HttpStatus status;
    final User user = Helpers.getAuthenticatedUser(session);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = ratingService.addRating(Rating
       .builder()
       .contentId(contentId)
       .score(Integer.parseInt(body.get(Constants.SCORE)))
       .userType(UserType.AUDIENCE)
       .reviewerId(user.getId())
       .username(user.getDisplayName())
       .body(body.get(Constants.BODY))
       .build()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @GetMapping(Constants.GET_RATING_BY_CONTENT_ID_MAPPING)
  public List<Rating> getRatingByContentId(@PathVariable final Integer contentId) {
    return ratingService.getRatingByContentId(contentId);
  }

  @GetMapping(Constants.GET_RATING_BY_REVIEWER_ID_MAPPING)
  public List<Rating> getRatingByReviewerId(@PathVariable final Integer reviewerId) {
    return ratingService.getRatingByReviewerId(reviewerId);
  }

  @DeleteMapping(Constants.DELETE_RATING_MAPPING)
  public ResponseEntity deleteRating(@PathVariable final Integer id) {
    final HttpStatus status;
    final User user = Helpers.getAuthenticatedUser(session);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      ratingService.deleteRating(id);
      status = HttpStatus.OK;
    }
    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.EDIT_RATING_MAPPING)
  public ResponseEntity editRating(@RequestBody final Map<String, String> body,
                                   @PathVariable final Integer ratingId) {
    final HttpStatus status;
    final User user = Helpers.getAuthenticatedUser(session);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = ratingService.editRating(Rating
       .builder()
       .id(ratingId)
       .score(Integer.parseInt(body.get(Constants.SCORE)))
       .userType(UserType.AUDIENCE)
       .reviewerId(user.getId())
       .username(user.getDisplayName())
       .body(body.get(Constants.BODY))
       .build()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }
}
