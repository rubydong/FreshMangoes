package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.contentType;
import com.freshmangoes.app.content.data.Episode;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlEpisodeRepository implements EpisodeRepository {
  @Override
  public Episode findEpisodeById(final int id) {
    // Return filler data for now
    return Episode
     .builder()
     .id(id)
     .type(contentType.EPISODE)
     .contentMetadata(ContentMetadata
      .builder()
      .audienceScore(25.2)
      .genres(new ImmutableList.Builder<String>()
       .add("Tragedy")
       .build())
      .mangoScore(22.5)
      .maturityRating("R")
      .name("Tokyo Ghoul")
      .runTime(160)
      .summary("Cannabalistic edgelords")
      .build())
     .build();
  }
}
