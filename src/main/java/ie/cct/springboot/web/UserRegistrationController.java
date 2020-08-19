package ie.cct.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.cct.springboot.service.UserService;
import ie.cct.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService; // inject userService interface implementation

	public UserRegistrationController(UserService userService) { // constructor based dependency injection
		super();
		this.userService = userService;
	}
	
	@PostMapping // handler method
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) { //user object contains form data (from the registration.html file)
																									// binded to the dto object through UserRegistration registrationDto	
		
		userService.save(registrationDto);																
		return "redirect:/registration?success"; // registration page with success message <div th:if="${param.success}">
		
		
		
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() { // method method that returns the registration view (registration.html is invoked)
		return "registration";
	}
	
	// Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate

}
