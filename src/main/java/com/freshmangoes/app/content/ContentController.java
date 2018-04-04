package com.freshmangoes.app.content;

import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.content.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ContentController {

  @Autowired
  private ContentService contentService;

  @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
  public Movie getMovie(@PathVariable int id) {
    return contentService.findMovieById(id);
  }

  @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
  public Show getShow(@PathVariable int id) {
    return contentService.findShowById(id);
  }

  @RequestMapping(value = "/show/*/{seasonId}", method = RequestMethod.GET)
  public Season getSeason(@PathVariable int seasonId) {
    return contentService.findSeasonById(seasonId);
  }

  @RequestMapping(value = "/show/*/*/{episodeId}", method = RequestMethod.GET)
  public Episode getEpisode(@PathVariable int episodeId) {
    return contentService.findEpisodeById(episodeId);
  }
}
