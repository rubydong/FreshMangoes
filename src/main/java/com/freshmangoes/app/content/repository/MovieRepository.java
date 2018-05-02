package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Movie;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
  Page<Movie> findByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(Double mangoScore, Pageable pageable);
  Page<Movie> findByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDescMetadata_ReleaseDateDesc(Double mangoScore, Pageable pageable);
  List<Movie> findByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(Date startDate, Date endDate);
  Page<Movie> findByOrderByRevenueDesc(Pageable pageable);
}
