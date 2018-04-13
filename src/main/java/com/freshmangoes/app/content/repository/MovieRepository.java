package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;

import java.util.List;

public interface MovieRepository extends ContentRepository {
  Movie findMovieById(int id);

  List<Movie> findAllMoviesLikeKeyword(String searchQuery);
}
