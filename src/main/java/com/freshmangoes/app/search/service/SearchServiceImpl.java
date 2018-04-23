package com.freshmangoes.app.search.service;

import com.freshmangoes.app.celebrity.repository.CelebritySearch;
import com.freshmangoes.app.content.repository.ContentSearch;
import com.freshmangoes.app.search.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
  @Autowired
  private CelebritySearch celebritySearch;

  @Autowired
  private ContentSearch contentSearch;

  public SearchResult searchByKeyword(final String searchQuery) {
    SearchResult searchResult = SearchResult.builder()
                                            .celebrities(celebritySearch.search(searchQuery))
                                            .content(contentSearch.search(searchQuery))
                                            .build();
    return searchResult;
  }

}
