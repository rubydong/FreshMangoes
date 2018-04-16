package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import java.util.List;

public interface MovieRepository {
  Movie findMovieById(int id);

  List<Movie> findAllMoviesLikeKeyword(String searchQuery);
}
