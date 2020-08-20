package ie.cct.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login") // this method handler is called from the browser (localhost:XXXX/login)
	public String login() {
		return "login"; // it returns the login thymeleaf template
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	/*
	@GetMapping("/booking")
	public String booking() {
		return "booking";
	}
	*/
	
	
	

}

//Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate
