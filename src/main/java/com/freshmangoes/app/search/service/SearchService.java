package com.freshmangoes.app.search.service;

import com.freshmangoes.app.search.data.SearchResult;

public interface SearchService {
  SearchResult searchAll(String text, Integer first, Integer max);
  SearchResult searchCelebrity(String text, Integer first, Integer max);
  SearchResult searchContent(String text, Integer first, Integer max);
}
