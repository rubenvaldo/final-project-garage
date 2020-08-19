package ie.cct.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ie.cct.springboot.service.UserService;

@Configuration
@EnableWebSecurity // integrates Spring Security with Spring MVC
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired // injects UserService interface
	private UserService userService;  
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() { // to encode password to the db
		return new BCryptPasswordEncoder();
	}
	
	// in order to integrate spring data JPA and hibernate with spring security
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); // need to implement UserDetailsService Interface (it has load user details method)
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception{ // configure the method and provide access to the different URLs like
		http.authorizeRequests().antMatchers(					  // a registration and JSS file, JS file, CSS and image
				"/registration**",
				"/js**",
				"/css**",
				"/img**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login") // give access to login page
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // when clicking logout, users should be allowed to return to login page
		.logoutSuccessUrl("/login?logout")
		.permitAll();
		
		// from this point, it's necessary to create a password encoder
	}
	
	//Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate

}
