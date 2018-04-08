package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.content.repository.ContentRepository;
import com.freshmangoes.app.content.repository.EpisodeRepository;
import com.freshmangoes.app.content.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
  @Autowired
  private ContentRepository mySQLContentRepository;

  @Autowired
  private SeasonRepository mySQLSeasonRepository;

  @Autowired
  private EpisodeRepository mySQLEpisodeRepository;

  public Movie findMovieById(final int id) {
    return mySQLContentRepository.findMovieById(id);
  }

  public Show findShowById(final int id) {
    return mySQLContentRepository.findShowById(id);
  }

  public Season findSeasonById(final int id) {
    return mySQLSeasonRepository.findSeasonById(id);
  }

  public Episode findEpisodeById(final int id) {
    return mySQLEpisodeRepository.findEpisodeById(id);
  }
}
