package com.freshmangoes.app.content.service;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.repository.EpisodeRepository;
import com.freshmangoes.app.content.repository.MovieRepository;
import com.freshmangoes.app.content.repository.SeasonRepository;
import com.freshmangoes.app.content.repository.ShowRepository;
import java.util.List;
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

  @Override
  public Season findSeason(int showId, int season) {
    final Show show = findShowById(showId);
    final List<Season> seasons;

    if (show != null) {
      seasons = show.getSeasons();
      return (season >= 0 && season < seasons.size()) ? seasons.get(season)
                                                      : null;
    } else {
      return null;
    }
  }

  @Override
  public Episode findEpisode(int showId, int season, int episode) {
    final Season s = findSeason(showId, season);
    final List<Episode> episodes;

    if (s != null) {
      episodes = s.getEpisodes();
      return (season >= 0 && season < episodes.size()) ? episodes.get(episode)
                                                       : null;
    } else {
      return null;
    }
  }
}
