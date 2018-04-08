package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.user.data.userType;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.celebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.rating.data.Rating;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlContentRepository implements ContentRepository {

  @Override
  public Boolean existsById(Integer id) {
    return null;
  }

  @Override
  public Movie findMovieById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
        .add(Rating
            .builder()
            .id(1)
            .type(userType.AUDIENCE)
            .body("Good movie, would recommend to other people")
            .score(89)
            .contentId(id)
            .build())
        .add(Rating
            .builder()
            .id(2)
            .type(userType.CRITIC)
            .body("Overhyped, generic superhero movie")
            .score(60)
            .contentId(id)
            .build())
        .build();


    List<String> genres = new ImmutableList.Builder<String>()
        .add("Action & Adventure")
        .add("Drama")
        .add("Science Fiction & Fantasy")
        .build();
    try {
      return Movie
          .builder()
          .id(id)
          .type(contentType.MOVIE)
          .ratings(ratings)
          .contentMetadata(ContentMetadata
              .builder()
              .releaseDate(new Date(1519776000000L))
              .cast(new ImmutableList.Builder<Celebrity>()
                  .add(Celebrity
                      .builder()
                      .name("Chadwick Boseman")
                      .id(0)
                      .type(celebrityType.ACTOR)
                      .profilePhoto(new URL("https://images/movie/cast1.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("T'Challa/Black Panther", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Michael B. Jordan")
                      .id(1)
                      .type(celebrityType.ACTOR)
                      .profilePhoto(new URL("https://images/movie/cast2.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("Erik Killmonger", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Lupita Nyong'o")
                      .id(2)
                      .type(celebrityType.ACTOR)
                      .profilePhoto(new URL("https://images/movie/cast3.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("Nakia", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Danai Gurira")
                      .id(3)
                      .type(celebrityType.ACTOR)
                      .profilePhoto(new URL("https://images/movie/cast4.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("Okoye", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Martin Freeman")
                      .id(4)
                      .type(celebrityType.ACTOR)
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("Everett K. Ross", Movie.builder().build()))
                          .build())
                      .profilePhoto(new URL("https://images/movie/cast5.png"))
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Daniel Kaluuya")
                      .id(5)
                      .type(celebrityType.ACTOR)
                      .profilePhoto(new URL("https://images/movie/cast6.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Black Panther",
                              new Pair<String, Movie>("W'Kabi", Movie.builder().build()))
                          .build())
                      .build())
                  .build())
              .audienceScore(77.0)
              .genres(genres)
              .mangoScore(97.0)
              .maturityRating("PG-13")
              .name("Black Panther")
              .runTime(135)
              .studio("Marvel Studios")
              .summary("Black Panther follows T'Challa who, after the events of '"
                  + "Captain America: Civil War,' returns home to the isolated, "
                  + "technologically advanced African nation of Wakanda to take his "
                  + "place as King. However, when an old enemy reappears on the radar, "
                  + "T'Challa's mettle as King and Black Panther is tested when he is "
                  + "drawn into a conflict that puts the entire fate of Wakanda and the world "
                  + "at risk.")
              .build())
          .summaryPhoto(new URL("https://images/movie/blackpanther.png"))
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://images/movie/bp1.png"))
                  .add(new URL("https://images/movie/bp2.png"))
                  .add(new URL("https://images/movie/bp3.png"))
                  .add(new URL("https://images/movie/bp4.png"))
                  .build())
              .videos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://videos/bptrailer.mp4"))
                  .add(new URL("https://videos/bptrailer.mp4"))
                  .add(new URL("https://videos/bptrailer.mp4"))
                  .build())
              .build())
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return Movie.builder().build();
  }

  @Override
  public Show findShowById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
        .add(Rating
            .builder()
            .id(3)
            .type(userType.AUDIENCE)
            .body("Could be better")
            .score(79)
            .contentId(id)
            .build())
        .add(Rating
            .builder()
            .id(4)
            .type(userType.CRITIC)
            .body("Best thriller of all time")
            .score(96)
            .contentId(id)
            .build())
        .build();
    try {
      return Show
          .builder()
          .id(2411)
          .type(contentType.SHOW)
          .seasons(new ImmutableList.Builder<Season>()
              .add(Season
                  .builder()
                  .type(contentType.SEASON)
                  .episodes(new ImmutableList.Builder<Episode>()
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .build())
                  .summaryPhoto(new URL("https://images/tvshow/strangerthings.png"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Stranger Things: Season 1")
                      .summary("Stranger Things' slow-building sophomore season balances moments of humor "
                          + "and a nostalgic sweetness against a growing horror that's all the more effective "
                          + "thanks to the show's full-bodied characters and evocative tone.")
                      .studio("Netflix")
                      .mangoScore(94.0)
                      .audienceScore(94.0)
                      .releaseDate(new Date(1483228800000L))
                      .build())
                  .build())
              .add(Season
                  .builder()
                  .type(contentType.SEASON)
                  .episodes(new ImmutableList.Builder<Episode>()
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .add(Episode.builder().build())
                      .build())
                  .summaryPhoto(new URL("https://images/tvshow/strangerfirst.png"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Stranger Things: Season 2")
                      .summary("Stranger Things' slow-building sophomore season balances moments of humor "
                          + "and a nostalgic sweetness against a growing horror that's all the more effective "
                          + "thanks to the show's full-bodied characters and evocative tone.")
                      .studio("Netflix")
                      .mangoScore(94.0)
                      .audienceScore(94.0)
                      .releaseDate(new Date(1483228800000L))
                      .build())
                  .build())
              .build())
          .summaryPhoto(new URL("https://images/tvshow/strangerfirst.png"))
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://images/tvshow/strangerphotos1.png"))
                  .add(new URL("https://images/tvshow/strangerphotos2.png"))
                  .add(new URL("https://images/tvshow/strangerphotos3.png"))
                  .add(new URL("https://images/tvshow/strangerphotos4.png"))
                  .build())
              .videos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://videos/strangervideo.mp4"))
                  .add(new URL("https://videos/strangervideo.mp4"))
                  .add(new URL("https://videos/strangervideo.mp4"))
                  .build())
              .build())
          .contentMetadata(ContentMetadata
              .builder()
              .name("Stranger Things")
              .summary("A love letter to the '80s classics that captivated a generation, Stranger Things "
                  + "is set in 1983 Indiana, where a young boy vanishes into thin air. As friends, family and "
                  + "local police search for answers, they are drawn into an extraordinary mystery involving top-secret "
                  + "government experiments, terrifying supernatural forces and one very strange little girl.")
              .genres(new ImmutableList.Builder<String>()
                  .add("Science Fiction & Fantasy")
                  .build())
              .mangoScore(94.0)
              .audienceScore(94.0)
              .releaseDate(new Date(1468540800000L))
              .studio("Netflix")
              .cast(new ImmutableList.Builder<Celebrity>()
                  .add(Celebrity
                      .builder()
                      .id(10)
                      .name("Winona Ryder")
                      .profilePhoto(new URL("https://images/tvshow/winona.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Joyce Byers", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(11)
                      .name("David Harbour")
                      .profilePhoto(new URL("https://images/tvshow/david.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Chief", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(12)
                      .name("Finn Wolfhard")
                      .profilePhoto(new URL("https://images/tvshow/finn.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Mike", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(13)
                      .name("Millie Bobbie Brown")
                      .profilePhoto(new URL("https://images/tvshow/millie.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Eleven", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(14)
                      .name("Gaten Matarazzo")
                      .profilePhoto(new URL("https://images/tvshow/gaten.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Dustin", Movie.builder().build()))
                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(15)
                      .name("Caleb Mclaughlin")
                      .profilePhoto(new URL("https://images/tvshow/caleb.png"))
                      .roles(new ImmutableMap.Builder<String, Pair<String,Movie>>()
                          .put("Stranger Things",
                              new Pair<String, Movie>("Lucas", Movie.builder().build()))
                          .build())
                      .build())
                  .build())
              .build()).build();


    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override
  public List<Movie> findAllMoviesLikeKeyword(final String searchQuery) {
    List<Movie> movies = new ArrayList<>();

    try {
      movies.add(
          Movie
              .builder()
              .id(3)
              .type(contentType.MOVIE)
              .summaryPhoto(new URL("https://images/search/pirate.png"))
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Pirates of the Caribbean: The Curse of the Black Pearl")
                  .releaseDate(new Date(1056770768000L))
                  .build())
              .build());

      movies.add(
          Movie
              .builder()
              .id(1)
              .type(contentType.MOVIE)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Panther")
                  .releaseDate(new Date(1519776000000L))
                  .build())
              .summaryPhoto(new URL("https://images/search/bp.png"))
              .build());

      movies.add(
          Movie
              .builder()
              .id(2)
              .type(contentType.MOVIE)
              .summaryPhoto(new URL("https://images/search/mib3.png"))
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Men In Black III")
                  .releaseDate(new Date(1337916368000L))
                  .build())
              .build());

      movies.add(
          Movie
              .builder()
              .id(4)
              .type(contentType.MOVIE)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Ruby")
                  .releaseDate(new Date(1526873168000L))
                  .build())
              .summaryPhoto(new URL("https://images/search/blackruby.png"))
              .build());

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(final String searchQuery) {
    List<Show> shows = new ArrayList<>();

    try {
      shows.add(
          Show
              .builder()
              .id(5)
              .type(contentType.SHOW)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Dynamite")
                  .build())
              .summaryPhoto(new URL("https://images/search/blackdynamite.png"))
              .build());

      shows.add(
          Show
              .builder()
              .id(6)
              .type(contentType.SHOW)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Mirror")
                  .build())
              .summaryPhoto(new URL("https://images/search/blackmirror.png"))
              .build());

      shows.add(
          Show
              .builder()
              .id(7)
              .type(contentType.SHOW)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Orphan Black")
                  .build())
              .summaryPhoto(new URL("https://images/search/orphanblack.png"))
              .build());

      shows.add(
          Show
              .builder()
              .id(5)
              .type(contentType.SHOW)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Dynamite")
                  .build())
              .summaryPhoto(new URL("https://images/search/blackdynamite.png"))
              .build());

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return shows;
  }
}
