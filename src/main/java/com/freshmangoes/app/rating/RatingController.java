package com.freshmangoes.app.rating;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.service.RatingService;
import com.freshmangoes.app.user.data.UserType;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @Autowired
  private HttpSession session;

//  @PostMapping(Constants.ADD_RATING_MAPPING)
//  public ResponseEntity addRating(@RequestBody final Map<String, String> body,
//                                  @PathVariable final Integer contentId) {
//    Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
//
//      if (userId == null) {
//        return ResponseEntity.badRequest().build();
//      } else {
//      return ratingService.addRating(contentId,
//                                       Integer.parseInt(body.get(Constants.SCORE)),
//                                       UserType.AUDIENCE,
//                                       userId,
//                                       body.get(Constants.BODY))
//             ? ResponseEntity.ok("Rating added successfully.")
//             : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rating was not added successfully.");
//    }
//  }

  @GetMapping(Constants.GET_RATING_BY_CONTENT_ID_MAPPING)
  public List<Rating> getRatingByContentId(@PathVariable final Integer contentId) {
    return ratingService.findByContentId(contentId);
  }

//  @GetMapping(Constants.GET_RATING_BY_REVIEWER_ID_MAPPING)
//  public List<Rating> getRatingByReviewerId(@PathVariable final Integer reviewerId) {
//    return ratingService.findByUserId(reviewerId);
//  }

//  @PostMapping(Constants.DELETE_RATING_MAPPING)
//  public ResponseEntity deleteRating(@PathVariable final Integer id) {
//    Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
//
//    if (userId == null) {
//      return ResponseEntity.badRequest().build();
//    } else {
//      ratingService.deleteRating(id);
//      return ResponseEntity.ok("Rating successfully deleted.");
//    }
//  }
//
//  @PostMapping(Constants.EDIT_RATING_MAPPING)
//  public ResponseEntity editRating(@RequestBody final Map<String, String> body,
//                                   @PathVariable final Integer ratingId) {
//    Integer userId = (Integer) session.getAttribute(Constants.USER_ID);
//
//    if (userId == null) {
//      return ResponseEntity.badRequest().build();
//    } else {
//      return ratingService.editRating(ratingId,
//                                      Integer.parseInt(body.get(Constants.SCORE)),
//                                      body.get(Constants.BODY))
//             ? ResponseEntity.ok("Rating edited successfully.")
//             : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rating was not edited successfully.");
//    }
//  }
}
