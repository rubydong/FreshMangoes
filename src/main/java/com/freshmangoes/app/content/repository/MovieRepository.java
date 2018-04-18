package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
  Movie findMovieById(int id);

//  List<Movie> findAllMoviesLikeKeyword(String searchQuery);
}
