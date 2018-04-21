package com.freshmangoes.app.celebrity.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.freshmangoes.app.common.data.Media;

import java.util.Date;
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

  @JoinTable(name = "celebrity_media",
      joinColumns = @JoinColumn(
          name = "celebrity_id",
          referencedColumnName = "id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "media_id",
          referencedColumnName = "id"
      ))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Media> media;

  @OneToMany
  @JoinColumn(name = "id")
  private List<Cast> roles;

  @OneToMany
  @JoinColumn(name = "id")
  private List<Crew> jobs;
}
