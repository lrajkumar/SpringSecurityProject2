package com.example.SpringSecurityTutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	  @GetMapping("/EnterDetails")
	  public String getBrowserName() {
		  return ("<h1>Welcome to spring Security Tutorial<h1>");
	  }
	
	  @GetMapping("/user")
	  public String getUser() {
		  return ("<h1>Welcome Userl<h1>");
	  }
	  
	  @GetMapping("/admin")
	  public String getAdmin() {
		  return ("<h1>Welcome Adminl<h1>");
	  } 
	  
	  
}
