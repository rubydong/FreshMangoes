package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Show")
public class Show extends Content {
  @OneToMany
  @JoinTable(
      name = "Show_Seasons",
      joinColumns =
      @JoinColumn(name = "show_id", referencedColumnName = "id"),
      inverseJoinColumns =
      @JoinColumn(name = "season_id", referencedColumnName = "id")
  )
  private List<Season> seasons;

  @Builder
  public Show(Integer id,
              ContentType type,
              List<Media> media,
              ContentMetadata contentMetadata,
              List<Season> seasons,
              List<Rating> ratings,
              Media summaryPhoto) {
    super.setId(id);
    super.setMedia(media);
    super.setMetadata(contentMetadata);
    super.setType(type);
    super.setSummaryPhoto(summaryPhoto);
    super.setRatings(ratings);
    this.seasons = seasons;
  }
}
