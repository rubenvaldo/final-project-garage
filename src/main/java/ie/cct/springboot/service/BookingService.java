package ie.cct.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ie.cct.springboot.model.Booking;
import ie.cct.springboot.web.dto.UserBookingDto;

public interface BookingService extends UserDetailsService {
	Booking save(UserBookingDto bookingDto);
	
	int getNumBookingsByDate(String date);
	// delete this
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public Collection<Booking> findByUserId(Long user_id);

}