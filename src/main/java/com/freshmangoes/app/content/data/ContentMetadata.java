package com.freshmangoes.app.content.data;

import com.freshmangoes.app.celebrity.data.Celebrity;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class ContentMetadata {
  @Id
  private int id;
  private String name;
  private String maturityRating;
  private String summary;
  private String studio;
  //private List<String> genres;
  private Integer runtime;
  private Double mangoScore;
  private Double audienceScore;
  private Date releaseDate;
}
