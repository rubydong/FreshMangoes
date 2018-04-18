package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlShowRepository implements ShowRepository {
  @Override
  public Show findShowById(int id) {
    return null;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(String searchQuery) {
    return null;
  }
}
