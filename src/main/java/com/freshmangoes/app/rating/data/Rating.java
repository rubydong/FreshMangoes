package com.freshmangoes.app.rating.data;

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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Ratings")
@Data
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
  private Content content;

  @ManyToOne
  private User user;
}
