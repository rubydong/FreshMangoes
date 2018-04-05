package com.freshmangoes.app.home;

import com.freshmangoes.app.home.data.IndexPageItems;
import com.freshmangoes.app.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
  @Autowired
  private HomeService homeService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public IndexPageItems getIndexPage() {
    return homeService.getIndexPageItems();
  }

}
