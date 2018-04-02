package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SearchController {

  @Autowired
  private SearchService searchService;


  @RequestMapping(value = "search", params = "query", method = RequestMethod.GET)
  public Celebrity doGet(
      @RequestParam("query") String keyword) {
    return celebrityService.getCelebrity(id);
  }
}
