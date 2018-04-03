package com.freshmangoes.app.search.service;

import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import com.freshmangoes.app.content.repository.ContentRepository;
import com.freshmangoes.app.search.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
  @Autowired
  private CelebrityRepository mySQLCelebrityRepository;

  @Autowired
  private ContentRepository contentRepository;

  public SearchResult searchByKeyword(String searchQuery) {
    SearchResult result = new SearchResult();
    result.setMovies(contentRepository.findAllMoviesLikeKeyword(searchQuery));
    result.setShows(contentRepository.findAllShowsLikeKeyword(searchQuery));
    result.setCelebrities(mySQLCelebrityRepository.findAllLikeKeyword(searchQuery));
    return result;
  }

}
