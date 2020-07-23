package ie.cct.springboot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ie.cct.springboot.model.Role;
import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.UserRepository;
import ie.cct.springboot.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

}
