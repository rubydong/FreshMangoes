package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show, Integer> {
  Page<Show> findByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(Double mangoScore, Pageable pageable);
}
