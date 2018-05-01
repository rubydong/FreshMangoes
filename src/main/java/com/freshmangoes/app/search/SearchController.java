package com.freshmangoes.app.search;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.search.data.SearchResult;
import com.freshmangoes.app.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

  @Autowired
  private SearchService searchService;

  @GetMapping(Constants.SEARCH_ALL_MAPPING)
  public SearchResult searchAll(@RequestParam final String query,
                                @RequestParam(defaultValue = "0") final Integer first,
                                @RequestParam(defaultValue = "2147483647") final Integer max) {
    return searchService.searchAll(query, first, max);
  }
}
