package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;

import java.util.List;

public interface CelebrityService {
  Celebrity getCelebrity(Integer id);

  List<Celebrity> getAllCelebrityById(Integer id);

  List<Celebrity> getAllCelebrityLikeKeyword(String searchQuery);

  Celebrity insertCelebrity(Celebrity celebrity);

  Boolean celebrityExists(Integer id);

  void deleteCelebrity(Integer id);
}
