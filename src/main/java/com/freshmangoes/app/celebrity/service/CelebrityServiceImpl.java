package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelebrityServiceImpl implements CelebrityService {

  @Autowired
  private CelebrityRepository celebrityRepository;

  public Celebrity getCelebrity(final Integer id) {
    return celebrityRepository.findById(id);
  }

  public List<Celebrity> getAllCelebrityById(final Integer id) {
    return celebrityRepository.findAllById(id);
  }

  public List<Celebrity> getAllCelebrityLikeKeyword(final String searchQuery) {
    return celebrityRepository.findAllLikeKeyword(searchQuery);
  }

  public Celebrity insertCelebrity(final Celebrity celebrity) {
    return celebrityRepository.save(celebrity);
  }

  public Boolean celebrityExists(final Integer id) {
    return celebrityRepository.existsById(id);
  }

  public void deleteCelebrity(final Integer id) {
    celebrityRepository.deleteById(id);
  }
}
