package com.freshmangoes.app.home.data;

import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import java.net.URL;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndexPageItems {
  private URL posterImage;
  private List<Movie> openingMovies;
  private List<Movie> topBoxOfficeMovies;
  private List<Movie> comingSoonMovies;
  private List<Show> newShows;
  private List<Show> mostPopularShows;
  private List<Show> topDVDStreamingShows;
}
