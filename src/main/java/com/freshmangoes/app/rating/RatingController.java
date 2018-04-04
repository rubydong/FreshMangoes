package com.freshmangoes.app.rating;


import com.freshmangoes.app.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RatingController {
  @Autowired
  private RatingService ratingService;

  @RequestMapping(value = "/rating/{contentId}", method = RequestMethod.POST)
  public boolean addRating(@PathVariable int contentId) {
    return ratingService.addToRating(null);
  }

}
