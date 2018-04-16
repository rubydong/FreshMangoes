package com.freshmangoes.app.search.service;

import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import com.freshmangoes.app.search.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
  @Autowired
  private CelebrityRepository celebrityRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ShowRepository showRepository;

  public SearchResult searchByKeyword(final String searchQuery) {
    return SearchResult
        .builder()
        .movies(movieRepository.findAllMoviesLikeKeyword(searchQuery))
        .shows(showRepository.findAllShowsLikeKeyword(searchQuery))
        .celebrities(celebrityRepository.findAllLikeKeyword(searchQuery))
        .build();
  }

}
