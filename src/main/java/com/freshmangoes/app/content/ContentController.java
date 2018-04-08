package com.freshmangoes.app.content;

import com.freshmangoes.app.common.data.Constants;
import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContentController {

  @Autowired
  private ContentService contentService;

  @GetMapping(Constants.MOVIE_MAPPING)
  public Movie getMovie(@PathVariable final int id) {
    return contentService.findMovieById(id);
  }

  @GetMapping(Constants.SHOW_MAPPING)
  public Show getShow(@PathVariable final int id) {
    return contentService.findShowById(id);
  }

  @GetMapping(Constants.SEASON_MAPPING)
  public Season getSeason(@PathVariable final int seasonId) {
    return contentService.findSeasonById(seasonId);
  }

  @GetMapping(Constants.EPISODE_MAPPING)
  public Episode getEpisode(@PathVariable final int episodeId) {
    return contentService.findEpisodeById(episodeId);
  }
}
