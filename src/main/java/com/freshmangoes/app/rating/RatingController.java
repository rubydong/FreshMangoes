package com.freshmangoes.app.rating;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.service.RatingService;
import com.freshmangoes.app.user.data.userType;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @Autowired
  private HttpSession session;

  @PostMapping(Constants.ADD_RATING_MAPPING)
  public ResponseEntity addRating(@RequestBody final Map<String, String> body,
                                  @PathVariable Integer contentId) {
    boolean result = ratingService.addToRating(contentId,
                                               Integer.parseInt(body.get(Constants.SCORE)),
                                               userType.AUDIENCE,
                                               (Integer) session.getAttribute(Constants.USER_ID),
                                               body.get(Constants.BODY));
    return result ? ResponseEntity.ok("Rating added successfully")
                  : ResponseEntity.status(490).body("Something went wrong");
  }

  @GetMapping("/rating/search")
  public List<Rating> getRating(@RequestParam("contentId") Optional<String> contentId,
                                @RequestParam("reviewerId") Optional<String> reviewerId) {
    if (!contentId.isPresent() && !reviewerId.isPresent()) {
      return ratingService.getRatingByReviewerId((Integer)session.getAttribute(Constants.USER_ID));
    } else if (reviewerId.isPresent()) {
      System.out.println(reviewerId);
      return ratingService.getRatingByReviewerId(Integer.parseInt(reviewerId.get()));
    } else {
      System.out.println(contentId);
      return ratingService.getRatingByContentId(Integer.parseInt(contentId.get()));
    }
  }
}
