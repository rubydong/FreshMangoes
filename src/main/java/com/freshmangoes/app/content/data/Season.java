package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

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


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(ContentType.Values.SEASON)
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
                List<Media> media,
                ContentMetadata contentMetadata,
                List<Episode> episodes,
                List<Rating> ratings,
                Media summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
    this.episodes = episodes;
  }
}
