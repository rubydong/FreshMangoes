package com.freshmangoes.app.content.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlContentRepository implements ContentRepository {
  @Override
  public Boolean existsById(Integer id) {
    return true;
  }
}
