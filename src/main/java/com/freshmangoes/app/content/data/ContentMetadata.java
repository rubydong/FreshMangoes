package com.freshmangoes.app.content.data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentMetadata {
  @Id
  private int id;

  @Column(name = "content_name")
  private String name;

  @Column(name = "maturity_rating")
  private String maturityRating;

  private String summary;

  @Column(name = "studio_network")
  private String studio;

  @ElementCollection
  @CollectionTable(name = "content_genre", joinColumns = @JoinColumn(name = "metadata_id"))
  @Column(name = "genre_id")
  private List<Integer> genres;

  private Integer runtime;

  @Column(name = "mango_score")
  private Double mangoScore;

  @Column(name = "audience_score")
  private Double audienceScore;

  @Column(name = "release_date")
  private Date releaseDate;
}
