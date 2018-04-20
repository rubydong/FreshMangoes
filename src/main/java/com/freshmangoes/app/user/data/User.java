package com.freshmangoes.app.user.data;

import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.rating.data.Rating;
import java.net.URL;
import java.util.List;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "Users")
public class User {
  @Id
  private Integer id;
  private String email;
  private String hash;
  private String displayName;
  private UserType type;
  private URL profilePicture;
  private Integer numFollowers;
  private Integer numFollowing;

  @JoinTable(name = "Followings")
  @OneToMany
  private List<User> followers;

  @JoinTable(name = "Followings")
  @OneToMany
  private List<User> following;

  @JoinTable(name = "Interests")
  @OneToMany
  private List<Content> interestedList;

  @JoinTable(name = "Disinterests")
  @OneToMany
  private List<Content> disinterestedList;

  @OneToMany
  @JoinColumn(name = "user_id")
  private List<Rating> ratings;
}
