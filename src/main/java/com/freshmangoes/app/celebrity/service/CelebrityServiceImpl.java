package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CelebrityServiceImpl implements CelebrityService {

  @Autowired
  private CelebrityRepository mySQLCelebrityRepository;

  public Celebrity getCelebrity(final int id) {
    return mySQLCelebrityRepository.findCelebrityById(id);
  }
}
