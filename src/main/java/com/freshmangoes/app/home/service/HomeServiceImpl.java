package com.freshmangoes.app.home.service;

import com.freshmangoes.app.content.data.ContentMetadata;
import com.freshmangoes.app.content.data.Movie;
import com.freshmangoes.app.content.data.Show;
import com.freshmangoes.app.home.data.IndexPageItems;
import com.google.common.collect.ImmutableList;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
  // Decide how to categorize Movies/Shows
  public IndexPageItems getIndexPageItems() {
    try {
      return IndexPageItems
          .builder()
          .posterImage(new URL("https://images/greatestshowmanbanner.jpg"))
          .openingMovies(new ImmutableList.Builder<Movie>()
              .add(Movie
                  .builder()
                  .id(0)
                  .summaryPhoto(new URL("https://images/posters/latest1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Peter Rabbit (2018)")
                      .mangoScore(95.0)
                      .audienceScore(95.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(1)
                  .summaryPhoto(new URL("https://images/posters/latest2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The 15:17 To Paris (2018)")
                      .mangoScore(58.0)
                      .audienceScore(58.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(2)
                  .summaryPhoto(new URL("https://images/posters/latest3.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Golden Exits (2018)")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(3)
                  .summaryPhoto(new URL("https://images/posters/latest4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Entanglement (2018)")
                      .mangoScore(39.0)
                      .audienceScore(39.0)
                      .build())
                  .build())
              .build())
          .comingSoonMovies(new ImmutableList.Builder<Movie>()
              .add(Movie
                  .builder()
                  .id(4)
                  .summaryPhoto(new URL("https://images/posters/latest1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Rascal Rebel Rabbit (2018)")
                      .mangoScore(95.0)
                      .audienceScore(95.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(5)
                  .summaryPhoto(new URL("https://images/posters/latest2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The 15:17 To Paris (2018)")
                      .mangoScore(58.0)
                      .audienceScore(58.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(6)
                  .summaryPhoto(new URL("https://images/posters/latest3.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Golden Exits (2018)")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(7)
                  .summaryPhoto(new URL("https://images/posters/latest4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Entanglement (2018)")
                      .mangoScore(39.0)
                      .audienceScore(39.0)
                      .build())
                  .build())
              .build())
          .topBoxOfficeMovies(new ImmutableList.Builder<Movie>()
              .add(Movie
                  .builder()
                  .id(8)
                  .summaryPhoto(new URL("https://images/posters/latest1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Peter Rabbit (2018)")
                      .mangoScore(95.0)
                      .audienceScore(95.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(9)
                  .summaryPhoto(new URL("https://images/posters/latest2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The 15:17 To Paris (2018)")
                      .mangoScore(58.0)
                      .audienceScore(58.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(10)
                  .summaryPhoto(new URL("https://images/posters/latest3.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Golden Exits (2018)")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Movie
                  .builder()
                  .id(11)
                  .summaryPhoto(new URL("https://images/posters/latest4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Entanglement (2018)")
                      .mangoScore(39.0)
                      .audienceScore(39.0)
                      .build())
                  .build())
              .build())
          .newShows(new ImmutableList.Builder<Show>()
              .add(Show
                  .builder()
                  .id(12)
                  .summaryPhoto(new URL("https://images/posters/new1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Kevin (Probably) Saves the World")
                      .mangoScore(63.0)
                      .audienceScore(63.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(13)
                  .summaryPhoto(new URL("https://images/posters/new2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The Frankenstein Chronicles")
                      .mangoScore(71.0)
                      .audienceScore(71.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(14)
                  .summaryPhoto(new URL("https://images/tvshow/strangerfirst.png"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Stranger Things")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(15)
                  .summaryPhoto(new URL("https://images/posters/new4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Baskets")
                      .mangoScore(66.0)
                      .audienceScore(66.0)
                      .build())
                  .build())
              .build())
          .mostPopularShows(new ImmutableList.Builder<Show>()
              .add(Show
                  .builder()
                  .id(16)
                  .summaryPhoto(new URL("https://images/posters/new1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Kevin (Probably) Saves the World")
                      .mangoScore(63.0)
                      .audienceScore(63.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(17)
                  .summaryPhoto(new URL("https://images/posters/new2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The Frankenstein Chronicles")
                      .mangoScore(71.0)
                      .audienceScore(71.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(18)
                  .summaryPhoto(new URL("https://images/posters/new3.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Another Period")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(19)
                  .summaryPhoto(new URL("https://images/posters/new4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Baskets")
                      .mangoScore(66.0)
                      .audienceScore(66.0)
                      .build())
                  .build())
              .build())
          .topDVDStreamingShows(new ImmutableList.Builder<Show>()
              .add(Show
                  .builder()
                  .id(20)
                  .summaryPhoto(new URL("https://images/posters/new1.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Kevin (Probably) Saves the World")
                      .mangoScore(63.0)
                      .audienceScore(63.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(21)
                  .summaryPhoto(new URL("https://images/posters/new2.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("The Frankenstein Chronicles")
                      .mangoScore(71.0)
                      .audienceScore(71.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(22)
                  .summaryPhoto(new URL("https://images/posters/new3.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Another Period")
                      .mangoScore(69.0)
                      .audienceScore(69.0)
                      .build())
                  .build())
              .add(Show
                  .builder()
                  .id(23)
                  .summaryPhoto(new URL("https://images/posters/new4.jpeg"))
                  .contentMetadata(ContentMetadata
                      .builder()
                      .name("Baskets")
                      .mangoScore(66.0)
                      .audienceScore(66.0)
                      .build())
                  .build())
              .build())
          .build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
