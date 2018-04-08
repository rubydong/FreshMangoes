package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.contentType;
import com.freshmangoes.app.content.data.Season;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;



@Repository
public class MySqlSeasonRepository implements SeasonRepository {
  @Override
  public Season findSeasonById(final int id) {
    // Return filler data for now
    return Season
     .builder()
     .id(id)
     .type(contentType.SEASON)
     .contentMetadata(ContentMetadata
      .builder()
      .audienceScore(25.2)
      .genres(new ImmutableList.Builder<String>()
       .add("Slice of Life")
       .build())
      .mangoScore(22.5)
      .maturityRating("PG13")
      .name("Flying Witch")
      .runTime(160)
      .summary("Farming life")
      .build())
     .build();
  }
}
