package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContentService {
  @Autowired
  private MySQLContentRepository mySQLContentRepository;

  public Content findMovieById(int id) {
    return mySQLContentRepository.findMovieById(id);
  }
}
