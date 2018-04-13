package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MySqlMovieRepository implements MovieRepository {

  @Override
  public Movie findMovieById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
     .add(Rating
      .builder()
      .id(1)
      .type(UserType.AUDIENCE)
      .body("Good movie, would recommend to other people")
      .score(89)
      .contentId(id)
      .build())
     .add(Rating
      .builder()
      .id(2)
      .type(UserType.CRITIC)
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
       .type(ContentType.MOVIE)
       .ratings(ratings)
       .contentMetadata(ContentMetadata
        .builder()
        .releaseDate(new Date(1519776000000L))
        .cast(new ImmutableList.Builder<Celebrity>()
         .add(Celebrity
          .builder()
          .name("Chadwick Boseman")
          .id(0)
          .type(CelebrityType.ACTOR)
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
          .type(CelebrityType.ACTOR)
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
          .type(CelebrityType.ACTOR)
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
          .type(CelebrityType.ACTOR)
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
          .type(CelebrityType.ACTOR)
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
          .type(CelebrityType.ACTOR)
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
  public List<Movie> findAllMoviesLikeKeyword(final String searchQuery) {
    List<Movie> movies = new ArrayList<>();

    try {
      movies.add(
       Movie
        .builder()
        .id(3)
        .type(ContentType.MOVIE)
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
        .type(ContentType.MOVIE)
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
        .type(ContentType.MOVIE)
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
        .type(ContentType.MOVIE)
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
}