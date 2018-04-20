package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@DiscriminatorValue(value = "movie")
public class Movie extends Content {
  @Builder
  public Movie(Integer id,
               ContentType type,
               List<Media> media,
               ContentMetadata contentMetadata,
               List<Rating> ratings,
               Media summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setType(type);
    super.setMetadata(contentMetadata);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
  }
}
