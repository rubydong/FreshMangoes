package com.freshmangoes.app.celebrity.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.freshmangoes.app.common.data.Media;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Celebrities")
public class Celebrity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @Column(name = "celebrity_name")
  private String name;
  private String birthplace;
  private String biography;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "profile_picture")
  private Media profilePicture;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Celebrity_Media")
  private List<Media> media;
}
