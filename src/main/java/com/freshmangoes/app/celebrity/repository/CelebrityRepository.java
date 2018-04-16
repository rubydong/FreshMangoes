package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import java.util.List;

public interface CelebrityRepository {
  Boolean existsById(Integer id);

  void deleteById(Integer id);

  Celebrity findById(Integer id);

  Celebrity save(Celebrity celebrity);

  List<Celebrity> findAllById(Integer id);

  List<Celebrity> findAllLikeKeyword(String searchQuery);
}
