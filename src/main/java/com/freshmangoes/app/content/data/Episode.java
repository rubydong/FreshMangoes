package com.freshmangoes.app.content.data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@AllArgsConstructor
@DiscriminatorValue("Episode")
public class Episode extends Content {

}
