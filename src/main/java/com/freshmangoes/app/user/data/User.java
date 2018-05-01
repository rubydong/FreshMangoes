package com.freshmangoes.app.user.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.rating.data.Rating;

import java.math.BigInteger;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


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
  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Content> interestedList;

  @JoinTable(name = "disinterests",
      joinColumns = @JoinColumn(
          name = "user_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "content_id"
      ))
  @ManyToMany(cascade = CascadeType.REMOVE)
  @JsonIgnoreProperties({"media", "ratings", "cast", "crew", "revenue", "views"})
  private List<Content> disinterestedList;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  @JsonIgnoreProperties({"flagged", "report"})
  private List<Rating> ratings;

  @JsonIgnore
  @Column(name = "verification_key")
  private String verificationKey;

  private Boolean verified;

  private BigInteger views;

  private Boolean isPrivate;
}
