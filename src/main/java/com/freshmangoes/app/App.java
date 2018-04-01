package com.freshmangoes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
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