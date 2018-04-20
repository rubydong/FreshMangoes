package com.freshmangoes.app.celebrity.service;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;

import java.util.List;

public interface CelebrityService {
  Celebrity getCelebrity(Integer id);

  Celebrity insertCelebrity(Celebrity celebrity);

  List<Media> findMediaByCelebrityId(Integer id);

  void deleteCelebrity(Integer id);

  List<Celebrity> findByContentId(Integer id);

//  List<Celebrity> findByNameLike(String searchQuery);
}
