package com.freshmangoes.app.rating.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@Table(name = "Ratings")
public class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//  @ManyToOne
//  @JoinColumn(name = "content_id", referencedColumnName = "id")
//  @JsonIgnore
//  private Content content;
//
//  @ManyToOne
//  @JoinColumn(name = "user_id")
//  @JsonIgnore
//  private User reviewer;
  private Integer score;
  private String body;
}
