package com.freshmangoes.app.search;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.search.data.SearchResult;
import com.freshmangoes.app.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

  @Autowired
  private SearchService searchService;

  @GetMapping(Constants.SEARCH_MAPPING)
  public SearchResult doGet(@RequestParam("query") final String searchQuery) {
    return searchService.searchByKeyword(searchQuery);
  }
}
