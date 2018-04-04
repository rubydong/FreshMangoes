package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.*;


public interface ContentService {
  Movie findMovieById(final int id);

  Show findShowById(final int id);

  Season findSeasonById(final int id);

  Episode findEpisodeById(final int id);
}
