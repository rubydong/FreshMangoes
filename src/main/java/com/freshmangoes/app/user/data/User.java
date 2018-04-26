package com.freshmangoes.app.user.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.rating.data.Rating;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;

  @JsonIgnore
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

  @JoinTable(name = "following",
      joinColumns = @JoinColumn(
          name = "followee_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "follower_id"
      ))
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonIgnoreProperties({"followers", "following", "interestedList", "disinterestedList", "ratings", "email"})
  private List<User> followers;

  @JoinTable(name = "following",
      joinColumns = @JoinColumn(
          name = "follower_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "followee_id"
      ))
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonIgnoreProperties({"followers", "following", "interestedList", "disinterestedList", "ratings", "email"})
  private List<User> following;

  @JoinTable(name = "interests",
      joinColumns = @JoinColumn(
          name = "user_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "content_id"
      ))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Content> interestedList;

  @JoinTable(name = "disinterests",
      joinColumns = @JoinColumn(
          name = "user_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "content_id"
      ))
  @ManyToMany(cascade = CascadeType.REMOVE)
  private List<Content> disinterestedList;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//  @JoinColumn(name = "id")
//  @JsonIgnoreProperties(value = {"user"})
  private List<Rating> ratings;

  @JsonIgnore
  @Column(name = "verification_key")
  private String verificationKey;

  private Boolean verified;
}
