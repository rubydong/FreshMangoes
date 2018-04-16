package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Season;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;



@Repository
public class MySqlSeasonRepository implements SeasonRepository {
  @Override
  public Season findSeasonById(final int id) {
    return null;
  }
}
