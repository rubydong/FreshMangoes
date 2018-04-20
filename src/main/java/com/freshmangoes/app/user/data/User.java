package com.freshmangoes.app.user.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.rating.data.Rating;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String hash;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "user_type")
  private UserType type;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "profile_picture")
  private Media profilePicture;

  @JsonInclude()
  @Transient
  private Integer numFollowers;

  @JsonInclude()
  @Transient
  private Integer numFollowing;

  @JsonInclude()
  @Transient
  private List<User> followers;

  @JsonInclude()
  @Transient
  private List<User> following;

  @JoinTable(name = "Interests")
  @OneToMany(cascade = CascadeType.ALL)
  private List<Content> interestedList;

  @JoinTable(name = "Disinterests")
  @OneToMany(cascade = CascadeType.ALL)
  private List<Content> disinterestedList;

  @JsonInclude()
  @Transient
  private List<Rating> ratings;


  private Boolean verified;
}
