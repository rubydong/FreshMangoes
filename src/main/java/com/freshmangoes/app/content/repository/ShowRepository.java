package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Show;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show, Integer> {
  List<Show> findTop10ByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(Double mangoScore);
}
