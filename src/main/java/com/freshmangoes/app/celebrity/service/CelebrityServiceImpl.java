package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CelebrityServiceImpl implements CelebrityService {

  @Autowired
  private CelebrityRepository celebrityRepository;

  public Celebrity getCelebrity(final Integer id) {
    Optional<Celebrity> celebrity = celebrityRepository.findById(id);
    return celebrity.orElse(null);
  }

  public Celebrity insertCelebrity(final Celebrity celebrity) {
    return celebrityRepository.save(celebrity);
  }
}
