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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Seasons")
@DiscriminatorValue(ContentType.Values.SEASON)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties("revenue")
public class Season extends Content {
  @OneToMany
  @JoinTable(
      name = "Season_Episodes",
      joinColumns =
      @JoinColumn(name = "season_id", referencedColumnName = "id"),
      inverseJoinColumns =
      @JoinColumn(name = "episode_id", referencedColumnName = "id")
  )
  private List<Episode> episodes;

  @Builder
  public Season(Integer id,
                ContentType type,
                Media summaryPhoto,
                List<Media> media,
                ContentMetadata metadata,
                List<Rating> ratings,
                List<Cast> cast,
                List<Crew> crew,
                BigInteger views,
                List<Episode> episodes) {
    super.setId(id);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setMedia(media);
    super.setMetadata(metadata);
    super.setRatings(ratings);
    super.setCast(cast);
    super.setCrew(crew);
    super.setViews(views);
    this.episodes = episodes;
  }
}
