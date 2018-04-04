package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.content.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContentServiceImpl implements ContentService {
  @Autowired
  private ContentRepository mySQLContentRepository;

  public Movie findMovieById(int id) {
    return mySQLContentRepository.findMovieById(id);
  }

  public Show findShowById(int id) {
    return mySQLContentRepository.findShowById(id);
  }

  public Season findSeasonById(int id) {
    return mySQLContentRepository.findSeasonById(id);
  }

  public Episode findEpisodeById(int id) {
    return mySQLContentRepository.findEpisodeById(id);
  }
}
