package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.content.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private SeasonRepository seasonRepository;

  @Autowired
  private EpisodeRepository episodeRepository;

  public Movie findMovieById(final int id) {
    return movieRepository.findMovieById(id);
  }

  public Show findShowById(final int id) {
    return showRepository.findShowById(id);
  }

  public Season findSeasonById(final int id) {
    return seasonRepository.findSeasonById(id);
  }

  public Episode findEpisodeById(final int id) {
    return episodeRepository.findEpisodeById(id);
  }
}
