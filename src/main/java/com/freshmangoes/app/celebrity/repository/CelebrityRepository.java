package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import java.util.List;

public interface CelebrityRepository {
  Celebrity findCelebrityById(int id);

  List<Celebrity> findAllLikeKeyword(String searchQuery);
}
