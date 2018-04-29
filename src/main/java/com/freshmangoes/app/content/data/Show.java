package com.freshmangoes.app.content.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
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
import org.hibernate.search.annotations.Indexed;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(ContentType.Values.SHOW)
@Indexed(index = "Content")
public class Show extends Content {
  @OneToMany(cascade = CascadeType.ALL)
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
