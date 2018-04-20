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
  public Season getSeason(@PathVariable("showId") final int showId,
                          @PathVariable("seasonId") final int seasonId) {
    Season s = contentService.findSeasonById(seasonId);
//    s.setRatings(ratingService.findByContentId(seasonId));
    return s;
  }

  @GetMapping(Constants.EPISODE_MAPPING)
  public Episode getEpisode(@PathVariable("showId") final int showId,
                            @PathVariable("seasonId") final int seasonId,
                            @PathVariable("episodeId") final int episodeId) {
    return contentService.findEpisodeById(episodeId);
  }
}
