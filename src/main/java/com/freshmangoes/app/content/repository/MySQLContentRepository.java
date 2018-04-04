package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.*;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MySQLContentRepository implements ContentRepository {

  @Override
  public Movie findMovieById(int id) {
    // Return filler data for now
    return Movie
            .builder()
            .id(id)
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
            .build();
  }

  @Override
  public Show findShowById(int id) {
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
  public List<Show> findAllShowsLikeKeyword(String searchQuery) {
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
            .build())
        .build());

    return shows;
  }
}
