package mmilan.MilanWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;

@Controller
public class MainFormController {

  @GetMapping("/")
  public String home(){
    return "home";
  }

  @GetMapping("/{userID}")
  public String home(@PathVariable("userID") long userID, Model model){
    model.addAttribute("userID", userID);

    return "home";
  }

}
