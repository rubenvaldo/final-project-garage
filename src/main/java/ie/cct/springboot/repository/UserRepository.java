package ie.cct.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.springboot.model.User;

@Repository // it leverages CRUD db operations for User JPA entity
public interface UserRepository extends JpaRepository<User, Long>{ // it exposes db CRUD operations
	
	User findByEmail(String email); // it retrieves a user object by email address

}


//Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate