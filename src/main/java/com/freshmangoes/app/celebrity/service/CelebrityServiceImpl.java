package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.repository.CelebrityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.freshmangoes.app.common.data.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CelebrityServiceImpl implements CelebrityService {

  @Autowired
  private CelebrityRepository celebrityRepository;

  @Override
  public Celebrity getCelebrity(final Integer id) {
    return celebrityRepository.findById(id).orElse(null);
  }

  @Override
  public Celebrity insertCelebrity(final Celebrity celebrity) {
    return celebrityRepository.save(celebrity);
  }

  public Boolean celebrityExists(final Integer id) {
    return celebrityRepository.existsById(id);
  }

  public void deleteCelebrity(final Integer id) {
    celebrityRepository.deleteById(id);
  }

  @Override
  public List<Media> findMediaByCelebrityId(final Integer id) {
    return celebrityRepository.findMediaByContentId(id);
  }

  public List<Celebrity> findByContentId(Integer id) {
    return celebrityRepository.findCelebrityByContentId(id);
  }
}
