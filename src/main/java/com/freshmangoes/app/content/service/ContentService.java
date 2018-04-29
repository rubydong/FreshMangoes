package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;

public interface ContentService {
  Movie findMovieById(int id);

  Show findShowById(int id);

  Season findSeason(int showId, int season);

  Episode findEpisode(int showId, int season, int episode);
}
