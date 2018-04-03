package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CelebrityService {

  @Autowired
  private CelebrityRepository celebrityRepository;

  public Celebrity getCelebrity(int id){
    return celebrityRepository.findCelebrityById(id);
  }
}
