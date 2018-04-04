package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.content.data.Episode;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Season;
import com.freshmangoes.app.content.data.Show;
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
public class MySQLContentRepository implements ContentRepository {

  @Override
  public Movie findMovieById(int id) {
    // Return filler data for now
    try {
      return Movie
          .builder()
          .id(id)
          .type(ContentType.Movie)
          .ratings(new ImmutableList.Builder<Rating>()
              .add(Rating
                  .builder()
                  .id(1337)
                  .reviewerId(7331)
                  .body("Good movie, would recommend to other people")
                  .score(2)
                  .contentId(12345)
                  .build())
              .build())
          .summaryPhoto(new URL("https://goo.gl/ZAaNHg"))
          .contentMetadata(ContentMetadata
              .builder()
              .audienceScore(25.2)
              .genres(new ImmutableList.Builder<String>()
                  .add("Action")
                  .add("Tragedy")
                  .add("Revenge")
                  .build())
              .mangoScore(22.5)
              .maturityRating("PG13")
              .name("Black Panther")
              .runTime(160)
              .summary("African warriors.")
              .build())
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Show findShowById(int id) {
    // Return filler data for now
    try {
      return Show
          .builder()
          .id(id)
          .type(ContentType.Show)
          .contentMetadata(ContentMetadata
              .builder()
              .audienceScore(54.2)
              .genres(new ImmutableList.Builder<String>()
                  .add("Comedy")
                  .build())
              .mangoScore(43.2)
              .maturityRating("R")
              .name("Durarara!!")
              .runTime(24)
              .summary("Supernatural japanese gangsters")
              .cast(new ImmutableMap.Builder<String, String>()
                  .put("Hiroshi Kamiya", "Izaya Orihara")
                  .build())
              .build())
          .media(Media
              .builder()
              .photos(new ImmutableList.Builder<URL>()
                  .add(new URL("https://google.com"))
                  .build())
              .build())
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Season findSeasonById(int id) {
    // Return filler data for now
    return Season
        .builder()
        .id(id)
        .type(ContentType.Season)
        .contentMetadata(ContentMetadata
            .builder()
            .audienceScore(25.2)
            .genres(new ImmutableList.Builder<String>()
                .add("Slice of Life")
                .build())
            .mangoScore(22.5)
            .maturityRating("PG13")
            .name("Flying Witch")
            .runTime(160)
            .summary("Farming life")
            .build())
        .build();
  }

  @Override
  public Episode findEpisodeById(int id) {
    // Return filler data for now
    return Episode
        .builder()
        .id(id)
        .type(ContentType.Episode)
        .contentMetadata(ContentMetadata
            .builder()
            .audienceScore(25.2)
            .genres(new ImmutableList.Builder<String>()
                .add("Tragedy")
                .build())
            .mangoScore(22.5)
            .maturityRating("R")
            .name("Tokyo Ghoul")
            .runTime(160)
            .summary("Cannabalistic edgelords")
            .build())
        .build();
  }

  @Override
  public List<Movie> findAllMoviesLikeKeyword(String searchQuery) {
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

    try {
      movies.add(
          Movie
              .builder()
              .id(15)
              .type(ContentType.Movie)
              .media(Media
                  .builder()
                  .photos(null)
                  .videos(null)
                  .build())
              .contentMetadata(ContentMetadata
                  .builder()
                  .audienceScore(25.2)
                  .genres(new ImmutableList.Builder<String>()
                      .add("Action")
                      .build())
                  .mangoScore(22.5)
                  .maturityRating("PG13")
                  .name("Black Panther")
                  .runTime(160)
                  .summary("African warriors.")
                  .releaseDate(new Date(880782472000L))
                  .cast(new ImmutableMap.Builder<String, String>()
                      .put("Chadwick Boseman", "T'Challa")
                      .build())
                  .build())
              .summaryPhoto(new URL("https://goo.gl/wdpmKu"))
              .ratings(new ImmutableList.Builder<Rating>()
                  .add(Rating
                      .builder()
                      .id(1337)
                      .reviewerId(7331)
                      .body("Good movie, would recommend to other people")
                      .score(2)
                      .contentId(12345)
                      .build())
                  .build())
              .build());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return movies;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(String searchQuery) {
    List<Show> shows = new ArrayList<>();
    try {
      shows.add(
          Show
              .builder()
              .id(62)
              .type(ContentType.Show)
              .media(Media
                  .builder()
                  .photos(null)
                  .videos(null)
                  .build())
              .contentMetadata(ContentMetadata
                  .builder()
                  .audienceScore(54.2)
                  .genres(new ImmutableList.Builder<String>()
                      .add("Comedy")
                      .build())
                  .mangoScore(43.2)
                  .maturityRating("R")
                  .name("Durarara!!")
                  .runTime(24)
                  .summary("Supernatural japanese gangsters")
                  .releaseDate(new Date(880782472000L))
                  .cast(new ImmutableMap.Builder<String, String>()
                      .put("Hiroshi Kamiya", "Izaya Orihara")
                      .build())
                  .build())
              .build());


      shows.add(
          Show
              .builder()
              .id(62)
              .type(ContentType.Show)
              .contentMetadata(ContentMetadata
                  .builder()
                  .audienceScore(54.2)
                  .genres(new ImmutableList.Builder<String>()
                      .add("Comedy")
                      .build())
                  .mangoScore(43.2)
                  .maturityRating("R")
                  .name("Durarara!!")
                  .runTime(24)
                  .summary("Supernatural japanese gangsters")
                  .releaseDate(new Date(880782472000L))
                  .cast(new ImmutableMap.Builder<String, String>()
                      .put("Hiroshi Kamiya", "Izaya Orihara")
                      .build())
                  .build())
              .media(Media
                  .builder()
                  .photos(new ImmutableList.Builder<URL>()
                      .add(new URL("https://google.com"))
                      .build())
                  .build())
              .build());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return shows;
  }
}
