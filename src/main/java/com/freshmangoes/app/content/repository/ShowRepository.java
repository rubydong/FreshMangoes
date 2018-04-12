package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Show;

import java.util.List;

public interface ShowRepository extends ContentRepository {
  Show findShowById(int id);

  List<Show> findAllShowsLikeKeyword(String searchQuery);
}
