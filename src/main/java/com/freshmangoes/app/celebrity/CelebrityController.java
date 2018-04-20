package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.service.CelebrityService;
import com.freshmangoes.app.common.data.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class CelebrityController {

  @Autowired
  private CelebrityService celebrityService;

  @GetMapping(Constants.GET_CELEBRITY_MAPPING)
  public Celebrity getCelebrity(@PathVariable final Integer id) {
    return celebrityService.getCelebrity(id);
  }

  @GetMapping(Constants.GET_ALL_CELEBRITY_MAPPING)
  public List<Celebrity> getCelebrityByContentId(@PathVariable final Integer id) {
    return celebrityService.findByContentId(id);
  }

  @PostMapping(Constants.INSERT_CELEBRITY_MAPPING)
  public ResponseEntity insertCelebrity(@RequestBody final Map<String, String> body) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, Integer.parseInt(body.get("Year")));
    cal.set(Calendar.MONTH, Integer.parseInt(body.get("Month")));
    cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(body.get("Day")));
    Date dateRepresentation = cal.getTime();

    return celebrityService.insertCelebrity(Celebrity
        .builder()
        .name(body.get("Name"))
        .birthday(dateRepresentation)
        .build()) == null
        ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        : ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping(Constants.DELETE_CELEBRITY_MAPPING)
  public void deleteCelebrity(@PathVariable final Integer id) {
    celebrityService.deleteCelebrity(id);
  }
}
