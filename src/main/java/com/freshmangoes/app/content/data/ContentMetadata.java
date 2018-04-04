package com.freshmangoes.app.content.data;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ContentMetadata {
  private String name;
  private String maturityRating;
  private String summary;
  private String studio;
  private List<String> genres;
  private Integer runTime;
  private Double mangoScore;
  private Double audienceScore;
  private Date releaseDate;
  private Map<String, String> cast;
}
