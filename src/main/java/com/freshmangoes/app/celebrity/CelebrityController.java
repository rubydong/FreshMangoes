package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.service.CelebrityService;
import com.freshmangoes.app.common.data.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CelebrityController {

  @Autowired
  private CelebrityService celebrityService;

  @GetMapping(Constants.CELEBRITY_MAPPING)
  public Celebrity doGet(@PathVariable final int id) {
    return celebrityService.getCelebrity(id);
  }
}
