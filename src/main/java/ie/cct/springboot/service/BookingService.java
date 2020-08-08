package ie.cct.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ie.cct.springboot.model.Booking;
import ie.cct.springboot.web.dto.UserBookingDto;

public interface BookingService extends UserDetailsService {
	Booking save(UserBookingDto bookingDto);

	// delete this
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}