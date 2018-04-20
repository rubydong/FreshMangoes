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
    return movieRepository.findById(id).orElse(null);
  }

  public Show findShowById(final int id) {
    return showRepository.findById(id).orElse(null);
  }

  public Season findSeasonById(final int id) {
    return seasonRepository.findById(id).orElse(null);
  }

  public Episode findEpisodeById(final int id) {
    return episodeRepository.findById(id).orElse(null);
  }
}
