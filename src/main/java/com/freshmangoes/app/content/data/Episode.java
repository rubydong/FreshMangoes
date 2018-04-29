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
import lombok.Setter;


@Entity(name = "Episodes")
@DiscriminatorValue(ContentType.Values.EPISODE)
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties("revenue")
public class Episode extends Content {
  @Builder
  public Episode(Integer id,
                 ContentType type,
                 Media summaryPhoto,
                 List<Media> media,
                 ContentMetadata metadata,
                 List<Rating> ratings,
                 List<Cast> cast,
                 List<Crew> crew,
                 BigInteger views) {
    super.setId(id);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setMedia(media);
    super.setMetadata(metadata);
    super.setRatings(ratings);
    super.setCast(cast);
    super.setCrew(crew);
    super.setViews(views);
  }
  public Content jsonToContent(String body) {
    return Episode.builder().build();
  }
}
