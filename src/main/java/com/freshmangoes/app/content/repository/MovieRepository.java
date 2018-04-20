package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
