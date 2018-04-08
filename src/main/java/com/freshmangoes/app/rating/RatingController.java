package com.freshmangoes.app.rating;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.rating.service.RatingService;
import com.freshmangoes.app.user.data.userType;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.RATING_MAPPING)
  public ResponseEntity addRating(@PathVariable final Integer contentId,
                                  @RequestParam final Integer score,
                                  @RequestParam final String body) {
    boolean result = ratingService.addToRating(contentId,
                                               score,
                                               userType.AUDIENCE,
                                               (Integer) session.getAttribute(Constants.USER_ID),
                                               body);
    return result ? ResponseEntity.ok("Rating added successfully")
                  : ResponseEntity.status(490).body("Something went wrong");
  }
}
