package ie.cct.springboot.service;

import ie.cct.springboot.model.User;
import ie.cct.springboot.web.dto.UserRegistrationDto;

public interface UserService {
	
	User save(UserRegistrationDto registrationDto);

}
