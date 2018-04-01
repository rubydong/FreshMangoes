package com.freshmangoes.app.common;


import java.util.Date;
import java.util.List;


import com.freshmangoes.app.celebrity.Celebrity;



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

  public ContentMetadata() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMaturityRating() {
    return maturityRating;
  }

  public void setMaturityRating(String maturityRating) {
    this.maturityRating = maturityRating;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public Integer getRunTime() {
    return runTime;
  }

  public void setRunTime(Integer runTime) {
    this.runTime = runTime;
  }

  public Double getMangoScore() {
    return mangoScore;
  }

  public void setMangoScore(Double mangoScore) {
    this.mangoScore = mangoScore;
  }

  public Double getAudienceScore() {
    return audienceScore;
  }

  public void setAudienceScore(Double audienceScore) {
    this.audienceScore = audienceScore;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public List<Celebrity> getCast() {
    return cast;
  }

  public void setCast(List<Celebrity> cast) {
    this.cast = cast;
  }
}
