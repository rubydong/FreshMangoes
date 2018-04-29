package com.freshmangoes.app.rating.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.user.data.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Ratings")
@Builder
@Getter
@Setter
@Table(name = "Ratings")
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "score")
  private Integer score;

  @Column(name = "body", columnDefinition = "text")
  private String body;

  @ManyToOne
  @JsonIgnoreProperties({"summaryPhoto", "media", "ratings", "cast", "crew"})
  private Content content;

  @ManyToOne
  @JsonIgnoreProperties({"email", "hash", "numFollowers", "numFollowing",
      "followers", "following", "interestedList", "disinterestedList", "verified", "ratings"})
  private User user;

  @Column(name = "flagged")
  private Boolean isFlagged;

  @Column(name = "report")
  private String report;
}
