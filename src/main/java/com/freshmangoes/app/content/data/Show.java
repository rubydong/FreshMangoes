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
@DiscriminatorValue("Show")
public class Show extends Content {
  @JoinTable(
      name = "Show_seasons",
      joinColumns =
      @JoinColumn(name = "season_id", referencedColumnName = "id"),
      inverseJoinColumns =
      @JoinColumn(name = "show_id", referencedColumnName = "id")
  )
  @OneToMany
  private List<Season> seasons;

  @Builder
  public Show(Integer id,
              ContentType type,
              Media media,
              ContentMetadata contentMetadata,
              List<Season> seasons,
              List<Rating> ratings,
              URL summaryPhoto) {
    super.setId(id);
    super.setMedia(null);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(null);
    super.setRatings(ratings);
    this.seasons = seasons;
  }
}
