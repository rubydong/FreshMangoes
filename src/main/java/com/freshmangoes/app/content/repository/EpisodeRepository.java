package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Episode;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Integer> {
  List<Episode> findByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(Date startDate, Date endDate);
  List<Episode> findByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderBySeason_Show_ViewsDesc(Date startDate, Date endDate);
}
