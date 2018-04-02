package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.content.repository.ContentRepositoryInterface;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;



@Repository
public class MySQLContentRepository implements ContentRepositoryInterface {

  @Override
  public Content findMovieById(int id) {
    // Return filler data for now
    return Content
            .builder()
            .id(id)
            .type(ContentType.Movie)
            .metadata(ContentMetadata
                        .builder()
                        .audienceScore(25.2)
                        .genres(new ImmutableList.Builder<String>()
                                      .add("Action")
                                      .build())
                        .mangoScore(22.5)
                        .maturityRating("PG13")
                        .name("Black Panther")
                        .runTime(160)
                        .summary("African warriors.")
                        .build())
            .build();
  }

  @Override
  public Content findShowById(int id) {
    // Return filler data for now
    return Content
            .builder()
            .id(id)
            .type(ContentType.Show)
            .metadata(ContentMetadata
                        .builder()
                        .audienceScore(54.2)
                        .genres(new ImmutableList.Builder<String>()
                                      .add("Comedy")
                                      .build())
                        .mangoScore(43.2)
                        .maturityRating("R")
                        .name("Durarara!!")
                        .runTime(24)
                        .summary("Supernatural japanese gangsters")
                        .build())
            .build();
  }

  @Override
  public Content findSeasonById(int id) {
    // Return filler data for now
    return Content
            .builder()
            .id(id)
            .type(ContentType.Season)
            .metadata(ContentMetadata
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

  @Override
  public Content findEpisodeById(int id) {
    // Return filler data for now
    return Content
            .builder()
            .id(id)
            .type(ContentType.Episode)
            .metadata(ContentMetadata
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
