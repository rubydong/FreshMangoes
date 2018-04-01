package com.freshmangoes.app.content;


import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
  private final ObjectMapper om = new ObjectMapper();

//  @RequestMapping("/movie/{id}")
//  public Random Test(@PathVariable int id) {
//    Random r = new Random();
//    r.id = 10;
//    r.name = "random";
//
//    return r;
//  }
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