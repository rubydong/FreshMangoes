package com.freshmangoes.app.home.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class SpotlightItems {
  private Media posterImage;
  private List<Movie> openingMovies;
  private List<Movie> topBoxOfficeMovies;
  private List<Movie> comingSoonMovies;
  private List<Show> newShows;
  private List<Show> mostPopularShows;
  private List<Show> topDVDStreamingShows;
}
