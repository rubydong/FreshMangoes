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

  public SearchResult searchAll(final String text, final Integer first, final Integer max) {
    SearchResult searchResult = SearchResult.builder()
                                            .celebrities(celebritySearch.search(text, first, max))
                                            .content(contentSearch.search(text, first, max))
                                            .build();
    return searchResult;
  }

  @Override
  public SearchResult searchCelebrity(String text, Integer first, Integer max) {
    SearchResult searchResult = SearchResult.builder()
                                            .celebrities(celebritySearch.search(text, first, max))
                                            .build();
    return searchResult;
  }

  @Override
  public SearchResult searchContent(String text, Integer first, Integer max) {
    SearchResult searchResult = SearchResult.builder()
                                            .content(contentSearch.search(text, first, max))
                                            .build();
    return searchResult;
  }

}
