package com.freshmangoes.app.content;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.service.ContentService;
import com.freshmangoes.app.rating.service.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

  @Autowired
  private ContentService contentService;

  @Autowired
  private RatingService ratingService;

  @GetMapping(Constants.MOVIE_MAPPING)
  public Movie getMovie(@PathVariable final int id) {
    return contentService.findMovieById(id);
  }

  @GetMapping(Constants.SHOW_MAPPING)
  public Show getShow(@PathVariable final int id) {
    return contentService.findShowById(id);
  }

  @GetMapping(Constants.SEASON_MAPPING)
  public Season getSeason(@PathVariable final int showId,
                          @PathVariable final int season) {
    final Show show = getShow(showId);
    final int actualSeason = season - 1;
    final List<Season> seasons;
    final Season s;

    if (show != null) {
      seasons = show.getSeasons();
      s = (actualSeason >= 0 && actualSeason < seasons.size()) ? seasons.get(actualSeason)
                                                               : null;
    } else {
      s = null;
    }

    return s;
  }

  @GetMapping(Constants.EPISODE_MAPPING)
  public Episode getEpisode(@PathVariable final int showId,
                            @PathVariable final int season,
                            @PathVariable final int episode) {
    final Season s = getSeason(showId, season);
    final int actualEpisode = episode - 1;
    List<Episode> episodes;
    Episode e;

    if (s != null) {
      episodes = s.getEpisodes();
      e = (actualEpisode >= 0 && actualEpisode < episodes.size()) ? episodes.get(actualEpisode)
                                                                  : null;
    } else {
      e = null;
    }

    return e;
  }
}
