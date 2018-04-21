package com.freshmangoes.app.content.data;

import com.freshmangoes.app.celebrity.data.Cast;
import com.freshmangoes.app.celebrity.data.Crew;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.rating.data.Rating;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity(name = "Content")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "content_type", columnDefinition = "tinyint")
@Table(name = "Content")
@Getter
@Setter
public abstract class Content {
  @Id
  @GeneratedValue
  private Integer id;

  @Enumerated
  @Column(name = "content_type", insertable = false, updatable = false)
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

  @OneToMany
  @JoinColumn(name = "id")
  private List<Rating> ratings;

  @OneToMany
  @JoinColumn(name = "id")
  private List<Cast> cast;

  @OneToMany
  @JoinColumn(name = "id")
  private List<Crew> crew;
}