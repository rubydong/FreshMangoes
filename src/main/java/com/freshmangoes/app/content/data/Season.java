package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.net.URL;

import java.util.List;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Season")
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
                Media media,
                ContentMetadata contentMetadata,
                List<Episode> episodes,
                List<Rating> ratings,
                URL summaryPhoto) {
    super.setId(id);
    super.setMedia(null);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(null);
    super.setRatings(ratings);
    this.episodes = episodes;
  }
}
