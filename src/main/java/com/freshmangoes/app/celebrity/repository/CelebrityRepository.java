package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import org.springframework.data.repository.CrudRepository;

public interface CelebrityRepository extends CrudRepository<Celebrity, Integer> {

}
