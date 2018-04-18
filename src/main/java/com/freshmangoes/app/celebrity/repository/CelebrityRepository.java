package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CelebrityRepository extends CrudRepository<Celebrity, Integer> {

}
