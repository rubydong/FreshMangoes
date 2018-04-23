package com.freshmangoes.app.content.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.GenerationType;
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
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;


@Entity(name = "Content")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "content_type", columnDefinition = "tinyint")
@Table(name = "Content")
@Indexed(index = "Content")
@Getter
@Setter
public abstract class Content {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
  @IndexedEmbedded
  private ContentMetadata metadata;

  @OneToMany(mappedBy = "content")
  @JsonIgnoreProperties("content")
  private List<Rating> ratings;

  @OneToMany(mappedBy = "content")
  @JsonIgnoreProperties("content")
  private List<Cast> cast;

  @OneToMany(mappedBy = "content")
  @JsonIgnoreProperties("content")
  private List<Crew> crew;
}