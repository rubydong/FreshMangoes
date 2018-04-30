package com.freshmangoes.app.home.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpotlightItems {
  private List<Media> posters;
  private List<Movie> openingThisWeek;
  private List<Movie> topBoxOffice;
  private List<Movie> comingSoon;
  private List<Movie> certifiedFreshMovies;
  private List<Movie> highestRatedMovies;

  private List<Show> newTonight;
  private List<Show> mostPopular;
  private List<Show> certifiedFreshShows;
  private List<Show> highestRatedShows;
}
