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

import com.google.common.collect.ImmutableMap;

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
          .profilePhoto(new URL("http://images/movie/cast1.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "T'Challa")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .name("Michael B. Jordan")
          .id(1)
          .type(CelebrityType.Actor)
          .profilePhoto(new URL("http://images/movie/cast2.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "Erik Killmonger")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .name("Lupita Nyong'o")
          .id(2)
          .type(CelebrityType.Actor)
          .profilePhoto(new URL("http://images/movie/cast3.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "Nakia")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .name("Danai Gurira")
          .id(3)
          .type(CelebrityType.Actor)
          .profilePhoto(new URL("http://images/movie/cast4.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "Okoye")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .name("Martin Freeman")
          .id(4)
          .type(CelebrityType.Actor)
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "Everett K. Ross")
           .build())
          .profilePhoto(new URL("http://images/movie/cast5.jpg"))
          .build())
         .add(Celebrity
          .builder()
          .name("Daniel Kaluuya")
          .id(5)
          .type(CelebrityType.Actor)
          .profilePhoto(new URL("http://images/movie/cast6.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Black Panther", "W'Kabi")
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
       .summaryPhoto(new URL("http://images/movie/blackpanther.jpg"))
       .media(Media
        .builder()
        .photos(new ImmutableList.Builder<URL>()
         .add(new URL("http://images/movie/bp1.jpg"))
         .add(new URL("http://images/movie/bp2.jpg"))
         .add(new URL("http://images/movie/bp3.jpg"))
         .add(new URL("http://images/movie/bp4.jpg"))
         .build())
        .videos(new ImmutableList.Builder<URL>()
         .add(new URL("http://videos/bptrailer.mp4"))
         .add(new URL("http://videos/bptrailer.mp4"))
         .add(new URL("http://videos/bptrailer.mp4"))
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
    try {
      return Show
       .builder()
       .id(2411)
       .type(ContentType.Show)
       .seasons(new ImmutableList.Builder<Season>()
        .add(Season
         .builder()
         .type(ContentType.Season)
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
         .summaryPhoto(new URL("http://images/tvshow/strangerthings.jpg"))
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
         .type(ContentType.Season)
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
         .summaryPhoto(new URL("http://images/tvshow/strangerfirst.jpg"))
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
       .summaryPhoto(new URL("http://images/tvshow/strangerfirst.jpg"))
       .media(Media
        .builder()
        .photos(new ImmutableList.Builder<URL>()
         .add(new URL("http://images/tvshow/strangerphotos1.jpg"))
         .add(new URL("http://images/tvshow/strangerphotos2.jpg"))
         .add(new URL("http://images/tvshow/strangerphotos3.jpg"))
         .add(new URL("http://images/tvshow/strangerphotos4.jpg"))
         .build())
        .videos(new ImmutableList.Builder<URL>()
         .add(new URL("http://videos/strangervideo.mp4"))
         .add(new URL("http://videos/strangervideo.mp4"))
         .add(new URL("http://videos/strangervideo.mp4"))
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
          .profilePhoto(new URL("http://images/tvshow/winona.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Joyce Byers")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(11)
          .name("David Harbour")
          .profilePhoto(new URL("http://images/tvshow/david.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Chief")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(12)
          .name("Finn Wolfhard")
          .profilePhoto(new URL("http://images/tvshow/finn.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Mike")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(13)
          .name("Millie Bobbie Brown")
          .profilePhoto(new URL("http://images/tvshow/millie.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Eleven")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(14)
          .name("Gaten Matarazzo")
          .profilePhoto(new URL("http://images/tvshow/gaten.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Dustin")
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(15)
          .name("Caleb Mclaughlin")
          .profilePhoto(new URL("http://images/tvshow/caleb.jpg"))
          .roles(new ImmutableMap.Builder<String, String>()
           .put("Stranger Things", "Lucas")
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

    movies.add(
     Movie
      .builder()
      .id(34)
      .type(ContentType.Movie)
      .media(Media
       .builder()
       .photos(null)
       .videos(null)
       .build())
      .contentMetadata(ContentMetadata
       .builder()
       .audienceScore(67.0)
       .genres(new ImmutableList.Builder<String>()
        .add("Action")
        .add("Science Fiction & Fantasy")
        .build())
       .mangoScore(33.2)
       .maturityRating("PG13")
       .name("Batman V Superman: Dawn of Justice")
       .runTime(151)
       .summary("Batman fights Superman.")
       .build())
      .build());

//    try {
//      movies.add(
//       Movie
//        .builder()
//        .id(15)
//        .type(ContentType.Movie)
//        .media(Media
//         .builder()
//         .photos(null)
//         .videos(null)
//         .build())
//        .contentMetadata(ContentMetadata
//         .builder()
//         .audienceScore(25.2)
//         .genres(new ImmutableList.Builder<String>()
//          .add("Action")
//          .build())
//         .mangoScore(22.5)
//         .maturityRating("PG13")
//         .name("Black Panther")
//         .runTime(160)
//         .summary("African warriors.")
//         .releaseDate(new Date(880782472000L))
//         .cast(new ImmutableMap.Builder<String, String>()
//          .put("Chadwick Boseman", "T'Challa")
//          .build())
//         .build())
//        .summaryPhoto(new URL("http://goo.gl/wdpmKu"))
//        .ratings(new ImmutableList.Builder<Rating>()
//         .add(Rating
//          .builder()
//          .id(1337)
//          .reviewerId(7331)
//          .body("Good movie, would recommend to other people")
//          .score(2)
//          .contentId(12345)
//          .build())
//         .build())
//        .build());
//    } catch (MalformedURLException e) {
//      e.printStackTrace();
//    }

    return movies;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(final String searchQuery) {
    List<Show> shows = new ArrayList<>();
//    try {
//      shows.add(
//       Show
//        .builder()
//        .id(62)
//        .type(ContentType.Show)
//        .media(Media
//         .builder()
//         .photos(null)
//         .videos(null)
//         .build())
//        .contentMetadata(ContentMetadata
//         .builder()
//         .audienceScore(54.2)
//         .genres(new ImmutableList.Builder<String>()
//          .add("Comedy")
//          .build())
//         .mangoScore(43.2)
//         .maturityRating("R")
//         .name("Durarara!!")
//         .runTime(24)
//         .summary("Supernatural japanese gangsters")
//         .releaseDate(new Date(880782472000L))
//         .cast(new ImmutableMap.Builder<String, String>()
//          .put("Hiroshi Kamiya", "Izaya Orihara")
//          .build())
//         .build())
//        .build());
//
//
//      shows.add(
//       Show
//        .builder()
//        .id(62)
//        .type(ContentType.Show)
//        .contentMetadata(ContentMetadata
//         .builder()
//         .audienceScore(54.2)
//         .genres(new ImmutableList.Builder<String>()
//          .add("Comedy")
//          .build())
//         .mangoScore(43.2)
//         .maturityRating("R")
//         .name("Durarara!!")
//         .runTime(24)
//         .summary("Supernatural japanese gangsters")
//         .releaseDate(new Date(880782472000L))
//         .cast(new ImmutableMap.Builder<String, String>()
//          .put("Hiroshi Kamiya", "Izaya Orihara")
//          .build())
//         .build())
//        .media(Media
//         .builder()
//         .photos(new ImmutableList.Builder<URL>()
//          .add(new URL("http://google.com"))
//          .build())
//         .build())
//        .build());
//    } catch (MalformedURLException e) {
//      e.printStackTrace();
//    }

    return shows;
  }
}
