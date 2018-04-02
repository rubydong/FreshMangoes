package com.freshmangoes.app.content.service;


import com.freshmangoes.app.content.data.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ContentController {

  @Autowired
  private ContentService contentService;

  @RequestMapping("/movie/{id}")
  public Content getMovie(@PathVariable int id) {
    return contentService.findMovieById(id);
  }

  @RequestMapping("/show/{id}")
  public Content getShow(@PathVariable int id) {
    return contentService.findShowById(id);
  }

  @RequestMapping("/show/*/{seasonId}")
  public Content getSeason(@PathVariable int seasonId) {
    return contentService.findSeasonById(seasonId);
  }

  @RequestMapping("/show/*/*/{episodeId}")
  public Content getEpisode(@PathVariable int episodeId) {
    return contentService.findEpisodeById(episodeId);
  }
}
