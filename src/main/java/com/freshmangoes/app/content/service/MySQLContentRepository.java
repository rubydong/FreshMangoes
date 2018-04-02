package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentRepositoryInterface;
import org.springframework.stereotype.Repository;



@Repository
public class MySQLContentRepository implements ContentRepositoryInterface {

  @Override
  public Content findMovieById(int id) {
    // Return filler data for now
    return Content.builder().id(id).build();
  }

  @Override
  public Content findShowById(int id) {
    // Return filler data for now
    return Content.builder().id(id).build();
  }

  @Override
  public Content findSeasonById(int id) {
    // Return filler data for now
    return Content.builder().id(id).build();
  }

  @Override
  public Content findEpisodeById(int id) {
    // Return filler data for now
    return Content.builder().id(id).build();
  }
}
