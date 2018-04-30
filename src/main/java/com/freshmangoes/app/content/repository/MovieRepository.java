package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
