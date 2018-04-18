package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.net.URL;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Builder
@AllArgsConstructor
@DiscriminatorValue(value = "movie")
public class Movie extends Content {
  @Builder
  public Movie(Integer id,
               ContentType type,
               Media media,
               ContentMetadata contentMetadata,
               List<Rating> ratings,
               URL summaryPhoto) {
    super.setId(id);
//    super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
//    super.setSummaryPhoto(summaryPhoto);
//    super.setRatings(ratings);
  }
}
