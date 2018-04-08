package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;
import java.util.List;

public interface ContentRepository {
  Boolean existsById(Integer id);

  Movie findMovieById(int id);

  Show findShowById(int id);

  List<Movie> findAllMoviesLikeKeyword(String searchQuery);

  List<Show> findAllShowsLikeKeyword(String searchQuery);
}
