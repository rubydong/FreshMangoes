package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.service.CelebrityServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CelebrityController {

  @Autowired
  private CelebrityServiceIntf celebrityService;

  @RequestMapping(value = "/celebrity/{id}", method = RequestMethod.GET)
  public Celebrity doGet(@PathVariable int id) {
    return celebrityService.getCelebrity(id);
  }
}
