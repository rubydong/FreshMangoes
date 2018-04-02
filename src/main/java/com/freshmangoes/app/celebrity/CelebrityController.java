package com.freshmangoes.app.celebrity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import com.freshmangoes.app.celebrity.data.Celebrity;

@RestController
public class CelebrityController {

  @JsonView(Celebrity.class)
  @RequestMapping(value = "/celebrity/{id}", method = RequestMethod.GET)
  public String doGet(
      @PathVariable int id) {
    CelebrityService cs = new CelebrityService();
    // return Json
    return cs.getById(id);
  }
}
