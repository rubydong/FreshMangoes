package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MetadataRepository extends CrudRepository<ContentMetadata, Integer> {
  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE  content_metadata, "
      + "(SELECT AVG(score) avg_score"
      + " FROM Ratings r"
      + " WHERE r.content_id = ?1"
      + ") b"
      + " SET audience_score = b.avg_score"
      + " WHERE id = ?1"
      , nativeQuery = true)
  void updateAudienceScore(Integer contentId);
}
