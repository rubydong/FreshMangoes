package com.freshmangoes.app.content.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Builder
@AllArgsConstructor
@DiscriminatorValue("Episode")
public class Episode extends Content {

}
