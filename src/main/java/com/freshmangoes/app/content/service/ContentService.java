package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;

public interface ContentService {
  Movie findMovieById(int id);

  Show findShowById(int id);

  Season findSeasonById(int id);

  Episode findEpisodeById(int id);
}
