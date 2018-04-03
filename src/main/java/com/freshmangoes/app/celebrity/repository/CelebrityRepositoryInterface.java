package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.content.data.Content;

import java.util.List;

public interface CelebrityRepositoryInterface {
  Celebrity findCelebrityById(int id);

  List<Celebrity> findAllLikeKeyword(String searchQuery);
}
