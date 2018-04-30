package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import java.util.Date;
import java.util.List;

public interface ContentService {
  Movie findMovieById(int id);

  List<Movie> findMovieByReleaseDateRange(Date startDate, Date endDate);

  List<Movie> findMoviesByRevenue(Integer page, Integer limit);

  List<Movie> findTop10MoviesWithMangoScoreGreaterThan(Double mangoScore);

  Show findShowById(int id);

  List<Show> findShowsByReleaseDateRange(Date startDate, Date endDate);


  Movie saveMovie(Movie movie);

  Show saveShow(Show show);

  Season saveSeason(Season season);

  Episode saveEpisode(Episode episode);
}
