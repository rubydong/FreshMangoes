package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.*;
import com.freshmangoes.app.rating.data.Rating;
import com.freshmangoes.app.user.data.UserType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlShowRepository implements ShowRepository {

  @Override
  public Show findShowById(final int id) {
    // Return filler data for now
    List<Rating> ratings = new ImmutableList.Builder<Rating>()
     .add(Rating
      .builder()
      .id(3)
      .userType(UserType.AUDIENCE)
      .body("Could be better")
      .score(79)
      .contentId(id)
      .build())
     .add(Rating
      .builder()
      .id(4)
      .userType(UserType.CRITIC)
      .body("Best thriller of all time")
      .score(96)
      .contentId(id)
      .build())
     .build();
    try {
      return Show
       .builder()
       .id(2411)
       .type(ContentType.SHOW)
       .seasons(new ImmutableList.Builder<Season>()
        .add(Season
         .builder()
         .type(ContentType.SEASON)
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
         .type(ContentType.SEASON)
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
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
           .put("Stranger Things",
            new Pair<String, Movie>("Joyce Byers", Movie.builder().build()))
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(11)
          .name("David Harbour")
          .profilePhoto(new URL("https://images/tvshow/david.png"))
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
           .put("Stranger Things",
            new Pair<String, Movie>("Chief", Movie.builder().build()))
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(12)
          .name("Finn Wolfhard")
          .profilePhoto(new URL("https://images/tvshow/finn.png"))
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
           .put("Stranger Things",
            new Pair<String, Movie>("Mike", Movie.builder().build()))
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(13)
          .name("Millie Bobbie Brown")
          .profilePhoto(new URL("https://images/tvshow/millie.png"))
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
           .put("Stranger Things",
            new Pair<String, Movie>("Eleven", Movie.builder().build()))
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(14)
          .name("Gaten Matarazzo")
          .profilePhoto(new URL("https://images/tvshow/gaten.png"))
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
           .put("Stranger Things",
            new Pair<String, Movie>("Dustin", Movie.builder().build()))
           .build())
          .build())
         .add(Celebrity
          .builder()
          .id(15)
          .name("Caleb Mclaughlin")
          .profilePhoto(new URL("https://images/tvshow/caleb.png"))
          .roles(new ImmutableMap.Builder<String, Pair<String, Movie>>()
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
  public List<Show> findAllShowsLikeKeyword(final String searchQuery) {
    List<Show> shows = new ArrayList<>();

    try {
      shows.add(
       Show
        .builder()
        .id(5)
        .type(ContentType.SHOW)
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
        .type(ContentType.SHOW)
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
        .type(ContentType.SHOW)
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
        .type(ContentType.SHOW)
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
