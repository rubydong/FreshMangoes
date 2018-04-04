package com.freshmangoes.app.search;

import com.freshmangoes.app.search.service.SearchServiceImpl;
import com.freshmangoes.app.search.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SearchController {

  @Autowired
  private SearchServiceImpl searchServiceImpl;

  @RequestMapping(value = "search", params = "query", method = RequestMethod.GET)
  public SearchResult doGet(
      @RequestParam("query") String searchQuery) {
    return searchServiceImpl.searchByKeyword(searchQuery);
  }
}
