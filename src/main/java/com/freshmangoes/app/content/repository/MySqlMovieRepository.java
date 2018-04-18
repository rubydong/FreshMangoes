package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlMovieRepository implements MovieRepository {
  @Override
  public Movie findMovieById(int id) {
    return null;
  }

  @Override
  public List<Movie> findAllMoviesLikeKeyword(String searchQuery) {
    return null;
  }
}
