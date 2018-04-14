package com.freshmangoes.app.celebrity;

import com.freshmangoes.app.celebrity.data.Celebrity;
import com.freshmangoes.app.celebrity.service.CelebrityService;
import com.freshmangoes.app.common.data.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public List<Celebrity> getAllCelebrity(@PathVariable final Integer id) {
    return celebrityService.getAllCelebrityById(id);
  }

  @GetMapping(Constants.GET_ALL_CELEBRITY_BY_KEYWORD_MAPPING)
  public List<Celebrity> searchCelebrityByKeyword(
   @RequestParam(value = "searchQuery") final String searchQuery) {
    return celebrityService.getAllCelebrityLikeKeyword(searchQuery);
  }

  @PostMapping(Constants.INSERT_CELEBRITY_MAPPING)
  public ResponseEntity insertCelebrity(@RequestBody final Map<String, String> body) {
    return celebrityService.insertCelebrity(Celebrity.builder().build()) == null
           ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
           : ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping(Constants.CHECK_CELEBRITY_EXISTS_MAPPING)
  public ResponseEntity checkCelebrityExists(@PathVariable final Integer id) {
    return celebrityService.celebrityExists(id)
           ? ResponseEntity.status(HttpStatus.OK).build()
           : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @PostMapping(Constants.DELETE_CELEBRITY_MAPPING)
  public void deleteCelebrity(@PathVariable final Integer id) {
    celebrityService.deleteCelebrity(id);
  }
}
