package com.freshmangoes.app.home.repository;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface SpotlightRepository {
  @Query("SELECT media_id FROM posters")
  List<Media> findAllPosters();

  @Query("SELECT movie_id FROM opening_this_week")
  List<Movie> findOpeningThisWeek();

  @Query("SELECT movie_id FROM top_box_office")
  List<Movie> findTopBoxOffice();

  @Query("SELECT movie_id FROM coming_soon")
  List<Movie> findComingSoon();

  @Query
  List<Movie> findHighestRated();

  @Query("SELECT movie_id FROM certified_fresh_movies")
  List<Movie> findCertifiedFreshMovies();

  @Query("SELECT show_id FROM new_tonight")
  List<Show> findNewTonight();

  @Query("SELECT show_id FROM most_popular")
  List<Show> findMostPopular();

  @Query("SELECT show_id FROM certified_fresh_shows")
  List<Show> findCertifiedFreshShows();

  @Query
  List<Show> findCurrentHighestRated();
}
