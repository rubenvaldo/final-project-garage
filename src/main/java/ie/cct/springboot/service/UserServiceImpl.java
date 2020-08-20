 package ie.cct.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import ie.cct.springboot.model.Role;
import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.UserRepository;
import ie.cct.springboot.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	private UserRepository userRepository; // to save user to the db
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; // provides encode method
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getPhoneNumber(),
				registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("USER"))); 
			
		
		return userRepository.save(user); // saves a user object to the db
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  // Security part
		User user = userRepository.findByEmail(username); // username = email address (comes from the login screen)
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){ // maps roles to the authorities
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		
	}
	
	// Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate

}
