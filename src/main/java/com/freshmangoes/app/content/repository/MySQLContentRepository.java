package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.data.CelebrityType;
import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.rating.data.UserType;
import com.google.common.collect.ImmutableList;
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
    try {
      return Movie
       .builder()
       .id(id)
       .type(ContentType.Movie)
       .ratings(new ImmutableList.Builder<Rating>()
       .add(Rating
        .builder()
        .id(1337)
        .type(UserType.Audience)
        .reviewerId(7331)
        .body("Good movie, would recommend to other people")
        .score(2)
        .contentId(12345)
        .build())
       .build())
       .summaryPhoto(new URL("https://goo.gl/ZAaNHg"))
            .contentMetadata(ContentMetadata
       .builder()
       .releaseDate(new Date(880782472000L))
       .cast(new ImmutableList.Builder<Celebrity>()
       .add(Celebrity
        .builder()
        .name("Chadwick Boseman")
        .id(id)
        .type(CelebrityType.Actor)
        .profilePhoto(new URL("https://goo.gl/wdpmKu"))
        .birthplace("Anderson, SC")
        .birthday(new Date(880782472000L))
        .biography("Studied acting at the British American Drama Academy "
         + "in Oxford after graduating from Howard University in "
         + "Washington, United States. Originally aspired to be a director. "
         + "Made his TV debut in a 2003 episode of Third Watch.")
        .media(null)
        .roles(null)
        .build()).build())
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
  public Show findShowById(final int id) {
    // Return filler data for now
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
                        .build())
            .build();
  }

  @Override
  public Season findSeasonById(final int id) {
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
  public Episode findEpisodeById(final int id) {
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
  public List<Movie> findAllMoviesLikeKeyword(final String searchQuery) {
    List<Movie> movies = new ArrayList<>();

    movies.add(
        Movie
        .builder()
        .id(34)
        .type(ContentType.Movie)
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

    movies.add(
        Movie
        .builder()
        .id(15)
        .type(ContentType.Movie)
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
            .build())
        .build());

    return movies;
  }

  @Override
  public List<Show> findAllShowsLikeKeyword(final String searchQuery) {
    List<Show>shows = new ArrayList<>();

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
            .cast(null)
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
            .cast(null)
            .build())
        .build());

    return shows;
  }
}
