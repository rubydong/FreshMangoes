package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.service.CelebrityService;
import com.freshmangoes.app.common.data.Constants;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freshmangoes.app.common.data.Media;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
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

//  @GetMapping(Constants.GET_ALL_CELEBRITY_MAPPING)
//  public List<Celebrity> getAllCelebrity(@PathVariable final Integer id) {
//    return celebrityService.getAllCelebrityById(id);
//  }
//
//  @GetMapping(Constants.GET_ALL_CELEBRITY_BY_KEYWORD_MAPPING)
//  public List<Celebrity> searchCelebrityByKeyword(@PathVariable final String searchQuery) {
//    return celebrityService.getAllCelebrityLikeKeyword(searchQuery);
//  }
//
//  @PostMapping(Constants.INSERT_CELEBRITY_MAPPING)
//  public ResponseEntity insertCelebrity(@RequestBody final Map<String, String> body) {
//    return celebrityService.insertCelebrity(Celebrity.builder().build()) == null
//        ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
//        : ResponseEntity.status(HttpStatus.OK).build();
//  }
//
//  @GetMapping(Constants.CHECK_CELEBRITY_EXISTS_MAPPING)
//  public ResponseEntity checkCelebrityExists(@PathVariable final Integer id) {
//    return celebrityService.celebrityExists(id)
//        ? ResponseEntity.status(HttpStatus.OK).build()
//        : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//  }
//
//  @PostMapping(Constants.DELETE_CELEBRITY_MAPPING)
//  public void deleteCelebrity(@PathVariable final Integer id) {
//    celebrityService.deleteCelebrity(id);
//  }
  //  @GetMapping(Constants.GET_ALL_CELEBRITY_MAPPING)
//  public List<Celebrity> getAllCelebrity(@PathVariable final Integer id) {
//    return celebrityService.getAllCelebrityById(id);
//  }
//
//  @GetMapping(Constants.GET_ALL_CELEBRITY_BY_KEYWORD_MAPPING)
//  public List<Celebrity> searchCelebrityByKeyword(
//   @RequestParam(value = "searchQuery") final String searchQuery) {
//    return celebrityService.getAllCelebrityLikeKeyword(searchQuery);
//  }
//
  @PostMapping(Constants.INSERT_CELEBRITY_MAPPING)
  public ResponseEntity insertCelebrity(@RequestBody final Map<String, String> body) {
    try {
      return celebrityService.insertCelebrity(Celebrity
       .builder()
       .name("Jack Zheng")
       .birthday(new Date(1996, 6, 28))
       .media(new ImmutableList.Builder<Media>()
        .add(Media.builder().path(new URL("https://www.google.com")).build()).build())
       .build()) == null
       ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
       : ResponseEntity.status(HttpStatus.OK).build();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }
//
//  @GetMapping(Constants.CHECK_CELEBRITY_EXISTS_MAPPING)
//  public ResponseEntity checkCelebrityExists(@PathVariable("id") final Integer id) {
//    return celebrityService.celebrityExists(id)
//           ? ResponseEntity.status(HttpStatus.OK).build()
//           : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//  }
//
//  @PostMapping(Constants.DELETE_CELEBRITY_MAPPING)
//  public void deleteCelebrity(@PathVariable final Integer id) {
//    celebrityService.deleteCelebrity(id);
//  }
}
