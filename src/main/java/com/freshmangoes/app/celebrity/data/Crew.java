package com.freshmangoes.app.celebrity.data;

import com.freshmangoes.app.content.data.Content;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Crew")
@Data
@Builder
@Getter
@Setter
@Table(name = "Crew")
@AllArgsConstructor
@NoArgsConstructor
public class Crew {
  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  private Celebrity celebrity;

  @ManyToOne
  private Content content;

  private String job;
}
