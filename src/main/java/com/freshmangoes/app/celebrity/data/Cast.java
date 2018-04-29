package com.freshmangoes.app.celebrity.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freshmangoes.app.content.data.Content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Cast")
@Data
@Builder
@Getter
@Setter
@Table(name = "Casted")
@AllArgsConstructor
@NoArgsConstructor
public class Cast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JsonIgnoreProperties({"birthday", "birthplace", "biography", "media", "roles", "jobs"})
  private Celebrity celebrity;

  @ManyToOne
  @JsonIgnoreProperties({"media", "ratings", "cast", "crew"})
  private Content content;

  @Column(columnDefinition = "text")
  private String role;
}
