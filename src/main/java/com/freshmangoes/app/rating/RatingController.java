package com.freshmangoes.app.rating;

import com.freshmangoes.app.rating.data.UserType;
import com.freshmangoes.app.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RatingController {
  @Autowired
  private RatingService ratingService;

  //@Autowired
  //private HttpSession httpSession;

  @RequestMapping(value = "/rating/{contentId}", method = RequestMethod.POST)
  public boolean addRating(@PathVariable Integer contentId,
                           @RequestParam Integer score,
                           @RequestParam String body) {
    // Replace 1337 with session
    return ratingService.addToRating(contentId,
                                     score,
                                     UserType.Audience,
                           1337,
                                     body);
  }
}
