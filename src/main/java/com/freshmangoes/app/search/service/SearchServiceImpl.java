package com.freshmangoes.app.search.service;

import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.content.repository.ContentRepository;
import com.freshmangoes.app.search.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl {
  @Autowired
  private CelebrityRepository mySQLCelebrityRepository;

  @Autowired
  private ContentRepository contentRepository;

  public SearchResult searchByKeyword(String searchQuery) {
      return SearchResult
              .builder()
              .movies(contentRepository.findAllMoviesLikeKeyword(searchQuery))
              .shows(contentRepository.findAllShowsLikeKeyword(searchQuery))
              .celebrities(mySQLCelebrityRepository.findAllLikeKeyword(searchQuery))
              .build();
  }

}
