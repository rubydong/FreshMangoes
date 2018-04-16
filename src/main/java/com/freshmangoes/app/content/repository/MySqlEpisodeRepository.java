package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Episode;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlEpisodeRepository implements EpisodeRepository {
  @Override
  public Episode findEpisodeById(final int id) {
    return null;
  }
}
