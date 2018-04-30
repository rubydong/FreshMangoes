package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.EpisodeRepository;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.SeasonRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

  @Override
  public List<Movie> findMovieByReleaseDateRange(Date startDate, Date endDate) {
    return movieRepository.findByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(startDate, endDate);
  }

  @Override
  public List<Movie> findMoviesByRevenue(Integer page, Integer limit) {
    return movieRepository.findByOrderByRevenueDesc(PageRequest.of(page, limit)).getContent();
  }

  @Override
  public List<Movie> findTop10MoviesWithMangoScoreGreaterThan(Double mangoScore) {
    return movieRepository.findTop10ByMetadata_MangoScoreGreaterThanOrderByMetadata_MangoScoreDesc(mangoScore);
  }

  public Show findShowById(final int id) {
    return showRepository.findById(id).orElse(null);
  }

  public List<Show> findShowsByReleaseDateRange(Date startDate, Date endDate) {
    List<Episode> episodes = episodeRepository.findByMetadata_ReleaseDateGreaterThanEqualAndMetadata_ReleaseDateLessThanEqualOrderByMetadata_ReleaseDateDesc(startDate, endDate);
    List<Show> shows = new ArrayList<>();

    for (Episode episode : episodes) {
      shows.add(episode.getSeason().getShow());
    }

    return shows;
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
