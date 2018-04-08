package com.freshmangoes.app.search.service;

import com.freshmangoes.app.search.data.SearchResult;

public interface SearchService {
  SearchResult searchByKeyword(String searchQuery);
}
