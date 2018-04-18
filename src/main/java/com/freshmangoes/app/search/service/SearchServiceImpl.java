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
  private CelebrityRepository mySQLCelebrityRepository;

  @Autowired
  private MovieRepository mySQLMovieRepository;

  @Autowired
  private ShowRepository mySQLShowRepository;

  public SearchResult searchByKeyword(final String searchQuery) {
    return null;
//      return SearchResult
//              .builder()
//              .movies(mySQLMovieRepository.findAllMoviesLikeKeyword(searchQuery))
//              .shows(mySQLShowRepository.findAllShowsLikeKeyword(searchQuery))
//              .celebrities(mySQLCelebrityRepository.findAllLikeKeyword(searchQuery))
//              .build();
  }

}
