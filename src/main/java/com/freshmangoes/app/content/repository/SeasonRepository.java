package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Season;

public interface SeasonRepository {
  Season findSeasonById(int id);
}
