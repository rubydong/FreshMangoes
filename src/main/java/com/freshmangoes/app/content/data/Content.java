
package com.freshmangoes.app.content.data;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.net.URL;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Content {
  @Id
  @GeneratedValue
  private Integer id;
  private ContentType type;

  @OneToOne
  @JoinColumn(name = "summary_photo")
  private Media summaryPhoto;

  @JoinTable(name = "ContentMedia")
  @OneToMany
  private List<Media> media;

  @OneToOne
  @JoinColumn(name = "metadata_id")
  private ContentMetadata metadata;

  @OneToMany
  @JoinColumn(name = "content_id")
  private List<Rating> ratings;

  @OneToMany
  @JoinTable(name = "Casted")
  private List<Celebrity> cast;

  @OneToMany
  @JoinTable(name = "Crew")
  private List<Celebrity> crew;
}
