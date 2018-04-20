package com.freshmangoes.app.celebrity.data;

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

//  @ManyToOne
//  @JoinTable(name = "Casted")
//  @JsonIgnore
//  private Content content;
}
