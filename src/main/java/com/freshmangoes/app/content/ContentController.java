package com.freshmangoes.app.content;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.service.ContentService;
import com.freshmangoes.app.rating.service.RatingService;
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
    return contentService.findSeason(showId - 1, season - 1);
  }

  @GetMapping(Constants.EPISODE_MAPPING)
  public Episode getEpisode(@PathVariable final int showId,
                            @PathVariable final int season,
                            @PathVariable final int episode) {
    return contentService.findEpisode(showId, season - 1, episode - 1);
  }
}
