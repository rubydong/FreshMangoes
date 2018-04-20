package com.freshmangoes.app.content.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Content")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ctype")
@Table(name = "Content")
@Getter
@Setter
public abstract class Content {
  @Id
  @GeneratedValue
  private Integer id;
  @Enumerated
  @Column(name = "content_type", columnDefinition = "tinyint")
  private ContentType type;

  @OneToOne
  @JoinColumn(name = "summary_photo")
  private Media summaryPhoto;

  @JoinTable(name = "Content_Media")
  @OneToMany
  private List<Media> media;

  @OneToOne
  @JoinColumn(name = "metadata_id")
  private ContentMetadata metadata;

  @JsonInclude()
  @Transient
  private List<Rating> ratings;

  @JsonInclude()
  @Transient
  private List<Celebrity> cast;

  @JsonInclude()
  @Transient
  private List<Celebrity> crew;
}
