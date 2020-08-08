package ie.cct.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ie.cct.springboot.model.Booking;
import ie.cct.springboot.model.Role;
import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.BookingRepository;
import ie.cct.springboot.repository.UserRepository;
import ie.cct.springboot.web.dto.UserBookingDto;

@Service
public class BookingServiceImpl implements BookingService{
	
	
	private BookingRepository bookingRepository;
	
	/*
	private UserRepository userRepository;
	

	//
	public BookingServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	*/


	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public Booking save(UserBookingDto bookingDto) {
		

		Booking booking = new Booking(bookingDto.getMake(), bookingDto.getType(), 
				bookingDto.getLicence_plate(), bookingDto.getEngine_type(),
				bookingDto.getService_type(), bookingDto.getDate(), bookingDto.getUser());
		
		/*
		Booking booking = new Booking(bookingDto.getMake(), bookingDto.getType(), 
				bookingDto.getLicence_plate(), bookingDto.getEngine_type(),
				bookingDto.getService_type(), bookingDto.getDate(), new User()); // need to double check
		*/
		return bookingRepository.save(booking);
				
	}


	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/*

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	*/

/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		*/
	

}