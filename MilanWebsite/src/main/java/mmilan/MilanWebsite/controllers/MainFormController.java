package mmilan.MilanWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainFormController {
  
  @GetMapping("/")
  public ModelAndView home(){
    ModelAndView modelAndView = new ModelAndView("home");
    return modelAndView;
  }
}
