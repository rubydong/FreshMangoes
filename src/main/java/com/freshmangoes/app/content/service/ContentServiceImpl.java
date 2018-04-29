package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.EpisodeRepository;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.SeasonRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

  @Autowired
  private ShowRepository showRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private SeasonRepository seasonRepository;

  @Autowired
  private EpisodeRepository episodeRepository;

  public Movie findMovieById(final int id) {
    return movieRepository.findById(id).orElse(null);
  }

  public Show findShowById(final int id) {
    return showRepository.findById(id).orElse(null);
  }

  public Movie saveMovie(final Movie movie) {
    return movieRepository.save(movie);
  }

  public Show saveShow(final Show show) {
    return showRepository.save(show);
  }

  public Season saveSeason(final Season season) {
    return seasonRepository.save(season);
  }

  public Episode saveEpisode(final Episode episode) {
    return episodeRepository.save(episode);
  }
}
