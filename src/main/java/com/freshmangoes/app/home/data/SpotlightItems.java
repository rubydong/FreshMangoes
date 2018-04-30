package com.freshmangoes.app.home.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Movie> openingThisWeek;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Movie> topBoxOffice;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Movie> comingSoon;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Movie> certifiedFreshMovies;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Movie> highestRatedMovies;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views", "seasons"})
  private List<Show> newTonight;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views", "seasons"})
  private List<Show> mostPopular;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views", "seasons"})
  private List<Show> certifiedFreshShows;

  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views", "seasons"})
  private List<Show> highestRatedShows;
}
