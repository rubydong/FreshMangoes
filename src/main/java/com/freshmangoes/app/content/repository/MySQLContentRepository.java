package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.data.UserType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class MySQLContentRepository implements ContentRepository {

  @Override
  public Movie findMovieById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
        .add(Rating
            .builder()
            .id(1)
            .type(UserType.Audience)
            .body("Good movie, would recommend to other people")
            .score(89)
            .contentId(id)
            .build())
        .add(Rating
            .builder()
            .id(2)
            .type(UserType.Critic)
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
          .type(ContentType.Movie)
          .ratings(ratings)
          .contentMetadata(ContentMetadata
              .builder()
              .releaseDate(new Date(1519776000000L))
              .cast(new ImmutableList.Builder<Celebrity>()
                  .add(Celebrity
                      .builder()
                      .name("Chadwick Boseman")
                      .id(0)
                      .type(CelebrityType.Actor)
                      .profilePhoto(new URL("https://images/movie/cast1.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "T'Challa")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Michael B. Jordan")
                      .id(1)
                      .type(CelebrityType.Actor)
                      .profilePhoto(new URL("https://images/movie/cast2.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "Erik Killmonger")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Lupita Nyong'o")
                      .id(2)
                      .type(CelebrityType.Actor)
                      .profilePhoto(new URL("https://images/movie/cast3.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "Nakia")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Danai Gurira")
                      .id(3)
                      .type(CelebrityType.Actor)
                      .profilePhoto(new URL("https://images/movie/cast4.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "Okoye")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Martin Freeman")
                      .id(4)
                      .type(CelebrityType.Actor)
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "Everett K. Ross")
//                          .build())
                      .profilePhoto(new URL("https://images/movie/cast5.jpg"))
                      .build())
                  .add(Celebrity
                      .builder()
                      .name("Daniel Kaluuya")
                      .id(5)
                      .type(CelebrityType.Actor)
                      .profilePhoto(new URL("https://images/movie/cast6.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Black Panther", "W'Kabi")
//                          .build())
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
          .summaryPhoto(new URL("https://images/movie/blackpanther.jpg"))
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://images/movie/bp1.jpg"))
                  .add(new URL("https://images/movie/bp2.jpg"))
                  .add(new URL("https://images/movie/bp3.jpg"))
                  .add(new URL("https://images/movie/bp4.jpg"))
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

    return null;
  }

  @Override
  public Show findShowById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
        .add(Rating
            .builder()
            .id(3)
            .type(UserType.Audience)
            .body("Could be better")
            .score(79)
            .contentId(id)
            .build())
        .add(Rating
            .builder()
            .id(4)
            .type(UserType.Critic)
            .body("Best thriller of all time")
            .score(96)
            .contentId(id)
            .build())
        .build();
    try {
      return Show
          .builder()
          .id(2411)
          .type(ContentType.Show)
          .summaryPhoto(new URL("http://images/tvshow/strangerfirst.jpg"))
          .ratings(ratings)
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://images/tvshow/strangerphotos1.jpg"))
                  .add(new URL("https://images/tvshow/strangerphotos2.jpg"))
                  .add(new URL("https://images/tvshow/strangerphotos3.jpg"))
                  .add(new URL("https://images/tvshow/strangerphotos4.jpg"))
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
              .summary("A love letter to the '80s classics that captivated a generation, Stranger "
                  + "Things is set in 1983 Indiana, where a young boy vanishes into thin air. "
                  + "As friends, family and local police search for answers, they are drawn into"
                  + "an extraordinary mystery involving top-secret government experiments,"
                  + " terrifying supernatural forces and one very strange little girl.")
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
                      .profilePhoto(new URL("https://images/tvshow/winona.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Joyce Byers")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(11)
                      .name("David Harbour")
                      .profilePhoto(new URL("https://images/tvshow/david.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Chief")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(12)
                      .name("Finn Wolfhard")
                      .profilePhoto(new URL("https://images/tvshow/finn.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Mike")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(13)
                      .name("Millie Bobbie Brown")
                      .profilePhoto(new URL("https://images/tvshow/millie.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Eleven")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(14)
                      .name("Gaten Matarazzo")
                      .profilePhoto(new URL("https://images/tvshow/gaten.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Dustin")
//                          .build())
                      .build())
                  .add(Celebrity
                      .builder()
                      .id(15)
                      .name("Caleb Mclaughlin")
                      .profilePhoto(new URL("https://images/tvshow/caleb.jpg"))
//                      .roles(new ImmutableMap.Builder<String, String>()
//                          .put("Stranger Things", "Lucas")
//                          .build())
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
              .type(ContentType.Movie)
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
              .type(ContentType.Movie)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Black Panther")
                  .releaseDate(new Date(1519776000000L))
                  .build())
              .summaryPhoto(new URL("https://images/search/bp.jpg"))
              .build());

      movies.add(
          Movie
              .builder()
              .id(2)
              .type(ContentType.Movie)
              .summaryPhoto(new URL("https://images/search/mib3.jpg"))
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
              .type(ContentType.Movie)
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
              .type(ContentType.Show)
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
              .type(ContentType.Show)
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
              .type(ContentType.Show)
              .contentMetadata(ContentMetadata
                  .builder()
                  .name("Orphan Black")
                  .build())
              .summaryPhoto(new URL("https://images/search/orphanblack.png"))
              .build());

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return shows;
  }
}
