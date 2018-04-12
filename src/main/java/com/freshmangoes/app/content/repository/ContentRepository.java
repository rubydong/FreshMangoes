package com.freshmangoes.app.content.repository;

public interface ContentRepository {
  default Boolean existsById(Integer id) {
    return true;
  }
}
