package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.content.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

  @Autowired
  private ShowRepository mySQLShowRepository;

  @Autowired
  private MovieRepository mySQLMovieRepository;

  @Autowired
  private SeasonRepository mySQLSeasonRepository;

  @Autowired
  private EpisodeRepository mySQLEpisodeRepository;

  public Movie findMovieById(final int id) {
    return mySQLMovieRepository.findMovieById(id);
  }

  public Show findShowById(final int id) {
    return mySQLShowRepository.findShowById(id);
  }

  public Season findSeasonById(final int id) {
    return mySQLSeasonRepository.findSeasonById(id);
  }

  public Episode findEpisodeById(final int id) {
    return mySQLEpisodeRepository.findEpisodeById(id);
  }
}
