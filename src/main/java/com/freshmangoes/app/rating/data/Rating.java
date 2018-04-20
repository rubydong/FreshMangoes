package com.freshmangoes.app.rating.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.ContentType;
import com.freshmangoes.app.user.data.User;
import com.freshmangoes.app.user.data.UserType;

import lombok.*;

import javax.persistence.*;

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
  private Integer score;
  private String body;

  @Column (name = "content_id")
  private Integer contentId;

  @JsonInclude()
  @Transient
  private String contentName;
}
