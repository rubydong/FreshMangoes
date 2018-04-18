package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show, Integer> {
  Show findShowById(int id);

  List<Show> findAllShowsLikeKeyword(String searchQuery);
}
