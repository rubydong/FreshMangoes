package com.freshmangoes.app.content.service;


import com.freshmangoes.app.content.data.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ContentController {

  @Autowired
  private ContentService contentService;

  @RequestMapping("/movie/{id}")
  public Content getMovie(@PathVariable int id) {
    return contentService.findMovieById(id);
  }
}

//package com.freshmangoes.movie;
//
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class TestController {
//
//  @GetMapping("/testing")
//  public String Test(@RequestParam(name = "name", required = false, defaultValue = "Jack Zheng")  String name,
//                     @RequestParam(name = "random", required = false, defaultValue= "random") String d,
//                     Model model) {
//    model.addAttribute("name", name);
//    model.addAttribute("random", d);
//    return "testing";
//  }
//
//}