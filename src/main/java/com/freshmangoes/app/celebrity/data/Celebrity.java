package com.freshmangoes.app.celebrity.data;

import com.freshmangoes.app.common.data.Media;
import com.freshmangoes.app.common.data.Pair;
import com.freshmangoes.app.content.data.Content;
import com.freshmangoes.app.content.data.Movie;

import java.net.URL;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "Celebrities")
public class Celebrity {
  //Todo Split this to break circular dependency
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date birthday;

  @Column(name = "celebrity_name")
  private String name;
  private String birthplace;
  private String biography;

  @OneToOne
  @JoinColumn(name = "profile_picture")
  private Media profilePicture;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "CelebrityMedia")
  private List<Media> media;

  private Celebrity() {};
}
