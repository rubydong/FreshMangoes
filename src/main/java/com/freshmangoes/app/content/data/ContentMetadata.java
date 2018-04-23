package com.freshmangoes.app.content.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContentMetadata {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "content_name")
  @Field
  private String name;

  @Column(name = "maturity_rating")
  private String maturityRating;

  @Column(columnDefinition = "text")
  private String summary;

  @Column(name = "studio_network")
  private String studio;

  @ElementCollection
  @CollectionTable(name = "content_genre", joinColumns = @JoinColumn(name = "metadata_id"))
  @Column(name = "genre")
  private List<Integer> genres;

  private Integer runtime;

  @Column(name = "mango_score")
  private Double mangoScore;

  @Column(name = "audience_score")
  private Double audienceScore;

  @Column(name = "release_date")
  private Date releaseDate;
}
