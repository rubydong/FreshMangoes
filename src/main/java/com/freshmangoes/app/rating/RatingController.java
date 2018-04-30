package com.freshmangoes.app.rating;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.common.helpers.Helpers;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.service.RatingService;
import com.freshmangoes.app.user.data.User;

import com.freshmangoes.app.user.service.UserService;
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
  private UserService userService;

  @Autowired
  private RatingService ratingService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.ADD_RATING_MAPPING)
  public ResponseEntity addRating(@RequestBody final Map<String, String> body,
                                  @PathVariable final Integer contentId) {
    final HttpStatus status;
    final Integer userId  = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = ratingService.addRating(
          contentId,
          body.get("type").equals("MOVIE") ? ContentType.MOVIE : ContentType.SHOW,
          Rating
              .builder()
              .content(null)
              .score(Integer.parseInt(body.get(Constants.SCORE)))
              .user(user)
              .body(body.get(Constants.BODY))
              .build()) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @DeleteMapping(Constants.DELETE_RATING_MAPPING)
  public ResponseEntity deleteRating(@PathVariable final Integer id) {
    final HttpStatus status;
    final Integer userId  = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      ratingService.deleteRating(user.getId(), id);
      status = HttpStatus.OK;
    }
    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.EDIT_RATING_MAPPING)
  public ResponseEntity editRating(@RequestBody final Map<String, String> body,
                                   @PathVariable final Integer ratingId) {
    final HttpStatus status;
    final Integer userId  = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = ratingService.editRating(user.getId(),
          Rating
              .builder()
              .id(ratingId)
              .content(null)
              .score(Integer.parseInt(body.get(Constants.SCORE)))
              .user(user)
              .body(body.get(Constants.BODY))
              .build()) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @PostMapping(Constants.FLAG_RATING_MAPPING)
  public ResponseEntity flagRating(@RequestBody final Map<String, String> body,
                                   @PathVariable final Integer ratingId) {
    final HttpStatus status;
    final Integer userId  = Helpers.getAuthenticatedUser(session);
    final User user = userService.getUser(userId);

    if (user == null) {
      status = HttpStatus.BAD_REQUEST;
    } else {
      status = ratingService.flagRating(ratingId, body.get(Constants.BODY)) != null
          ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
    return ResponseEntity.status(status).build();
  }

  @GetMapping(Constants.GET_RATING_BY_USER_ID_MAPPING)
  public List<Rating> getRatingByUserId(@PathVariable final Integer userId) {
    return ratingService.findByUserId(userId);
  }

  @GetMapping(Constants.GET_RATING_BY_CONTENT_ID_MAPPING)
  public List<Rating> getRatingByContentId(@PathVariable final Integer contentId) {
    return ratingService.findByContentId(contentId);
  }

  @GetMapping(Constants.GET_LATEST_RATINGS)
  public List<Rating> getLatestRatings() {
    return ratingService.getLatestRatings();
  }

}
