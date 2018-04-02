package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.repository.MySQLContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContentService {
  @Autowired
  private MySQLContentRepository mySQLContentRepository;

  public Content findMovieById(int id) {
    return mySQLContentRepository.findMovieById(id);
  }

  public Content findShowById(int id) {
    return mySQLContentRepository.findShowById(id);
  }

  public Content findSeasonById(int id) {
    return mySQLContentRepository.findSeasonById(id);
  }

  public Content findEpisodeById(int id) {
    return mySQLContentRepository.findEpisodeById(id);
  }
}
