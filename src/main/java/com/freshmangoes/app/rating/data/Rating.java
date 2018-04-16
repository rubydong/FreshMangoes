package com.freshmangoes.app.rating.data;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "Ratings")
public class Rating {
  @Id
  private Integer id;

  @OneToOne
  @JoinColumn(name = "content_id")
  private Content content;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User reviewer;
  private Integer score;
  private String body;
}
