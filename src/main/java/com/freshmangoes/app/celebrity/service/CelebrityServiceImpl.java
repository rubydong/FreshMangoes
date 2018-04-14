package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelebrityServiceImpl implements CelebrityService {

  @Autowired
  private CelebrityRepository mySQLCelebrityRepository;

  public Celebrity getCelebrity(final Integer id) {
    return mySQLCelebrityRepository.findById(id);
  }

  public List<Celebrity> getAllCelebrityById(final Integer id) {
    return mySQLCelebrityRepository.findAllById(id);
  }

  public List<Celebrity> getAllCelebrityLikeKeyword(final String searchQuery) {
    return mySQLCelebrityRepository.findAllLikeKeyword(searchQuery);
  }

  public Celebrity insertCelebrity(final Celebrity celebrity) {
    return mySQLCelebrityRepository.save(celebrity);
  }

  public Boolean celebrityExists(final Integer id) {
    return mySQLCelebrityRepository.existsById(id);
  }

  public void deleteCelebrity(final Integer id) {
    mySQLCelebrityRepository.deleteById(id);
  }
}
