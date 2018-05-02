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
      + " FROM Ratings r, Users u"
      + " WHERE r.content_id = ?1"
      + " AND u.user_type = 0"
      + " AND r.user_id = u.id"
      + ") b"
      + " SET audience_score = b.avg_score"
      + " WHERE id = ?1"
      , nativeQuery = true)
  void updateAudienceScore(Integer contentId);

  @Transactional
  @Modifying(clearAutomatically = true)
  @Query(value = "UPDATE  content_metadata, "
      + "(SELECT AVG(score) avg_score"
      + " FROM Ratings r, Users u"
      + " WHERE r.content_id = ?1"
      + " AND u.user_type = 1"
      + " AND r.user_id = u.id"
      + ") b"
      + " SET mango_score = b.avg_score"
      + " WHERE id = ?1"
      , nativeQuery = true)
  void updateMangoScore(Integer contentId);
}
