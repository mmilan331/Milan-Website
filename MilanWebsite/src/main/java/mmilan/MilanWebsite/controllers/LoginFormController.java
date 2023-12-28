package mmilan.MilanWebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import mmilan.MilanWebsite.models.Account;
import mmilan.MilanWebsite.repository.AccountDatabase;

@Controller
public class LoginFormController {

  @Autowired
  private AccountDatabase accountDB;

//Login Mappings
  @GetMapping("/login")
  public String loginPage(){
    return "login";
  }

  @PostMapping("/loginAttempt")
  public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
    Account user = accountDB.findByUsername(username);
    if (user != null && user.getPassword().equals(password)){
      session.setAttribute("username", user.getUsername());
      session.setAttribute("accountID", user.getAccountID());
      return "redirect:/" + user.getAccountID();
    }
    else{
      model.addAttribute("error", "Invalid username or password");
      return "login";
    }
  }

//Signup Mappings
  @GetMapping("/signup")
  public String signupPage(){
    return "signup";
  }
  
  @PostMapping("/login")
  public String signup(){
    return "redirect:/login";
  }

//Logout Mappings
  @GetMapping("/logout")
  public String logout(HttpSession session){
    session.invalidate();
    return "redirect:/";
  }
}
