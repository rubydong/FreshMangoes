package com.freshmangoes.app.content.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository {
  Boolean existsById(Integer id);
}
