package com.freshmangoes.app.celebrity.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.common.data.Media;

import java.util.Date;
import java.util.List;

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


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Celebrities")
@Getter
@Setter
public class Celebrity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @Column(name = "celebrity_name")
  private String name;

  private String birthplace;

  @Column(columnDefinition = "text")
  private String biography;

  @OneToOne
  @JoinColumn(name = "profile_picture")
  private Media profilePicture;

  @JoinTable(name = "celebrity_media",
      joinColumns = @JoinColumn(
          name = "celebrity_id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "media_id"
      ))
  @ManyToMany
  private List<Media> media;

  @OneToMany(mappedBy = "celebrity")
  @JsonIgnoreProperties("celebrity")
  private List<Cast> roles;

  @OneToMany(mappedBy = "celebrity")
  @JsonIgnoreProperties("celebrity")
  private List<Crew> jobs;
}
