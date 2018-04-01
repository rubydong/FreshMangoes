package com.freshmangoes.app.content.data;

import com.freshmangoes.app.celebrity.data.Celebrity;
import java.util.Date;
import java.util.List;
import lombok.Builder;



@Builder
public class ContentMetadata {
  private String name;
  private String maturityRating;
  private String summary;
  private List<String> genres;
  private Integer runTime;
  private Double mangoScore;
  private Double audienceScore;
  private Date releaseDate;
  private List<Celebrity> cast;
}
