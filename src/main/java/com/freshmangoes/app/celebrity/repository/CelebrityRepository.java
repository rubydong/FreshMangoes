package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CelebrityRepository extends CrudRepository<Celebrity, Integer> {
  @Query(value = "SELECT * FROM celebrity_media WHERE celebrity_id = ?1", nativeQuery = true)
  List<Media> findMediaByContentId(Integer id);

  @Query(value = "SELECT c.* FROM celebrities c "
      + "JOIN casted ca on c.id = ca.celebrity_id and content_id = ?1", nativeQuery = true)
  List<Celebrity> findCelebrityByContentId(Integer id);

}
