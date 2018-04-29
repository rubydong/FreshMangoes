package com.freshmangoes.app.content.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Crew;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Indexed;


@Entity(name = "Movies")
@DiscriminatorValue(ContentType.Values.MOVIE)
@Indexed(index = "Content")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Movie extends Content {

  private BigInteger revenue;

  @Builder
  public Movie(Integer id,
               ContentType type,
               Media summaryPhoto,
               List<Media> media,
               ContentMetadata metadata,
               List<Rating> ratings,
               List<Cast> cast,
               List<Crew> crew,
               BigInteger views,
               BigInteger revenue) {
    super.setId(id);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setMedia(media);
    super.setMetadata(metadata);
    super.setRatings(ratings);
    super.setCast(cast);
    super.setCrew(crew);
    super.setViews(views);
    this.revenue = revenue;
  }
}
