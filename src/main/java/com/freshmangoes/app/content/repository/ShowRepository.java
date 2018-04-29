package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer> {

}
