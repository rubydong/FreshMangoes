package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MetadataRepository extends CrudRepository<ContentMetadata, Integer> {

//  @Query(value = "UPDATE  content_metadata a"
//      + "CROSS JOIN"
//      + "(SELECT AVG(score) avg_score"
//      + " FROM Ratings"
//      + " WHERE content_id = ?1"
//      + ") b"
//      + " SET     a.audience_score = b.avg_score"
//      + " WHERE   a.username = ?1", nativeQuery = true)
//  void updateAudienceScore(Integer contentId);
}
