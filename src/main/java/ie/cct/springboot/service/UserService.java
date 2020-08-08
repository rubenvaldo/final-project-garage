package ie.cct.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ie.cct.springboot.model.User;
import ie.cct.springboot.web.dto.UserRegistrationDto;

public interface UserService  extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}