package ie.cct.springboot.service;

import java.util.Arrays;
import java.time.LocalDate;

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
	
	

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public Booking save(UserBookingDto bookingDto) {
		

		Booking booking = new Booking(bookingDto.getMake(), bookingDto.getType(), 
				bookingDto.getLicence_plate(), bookingDto.getEngine_type(),
				bookingDto.getService_type(), bookingDto.getComment(), bookingDto.getDate(), bookingDto.getUser());
		
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


	@Override
	public int getNumBookingsByDate(String date) {
		int numBookingsOnThisDate = bookingRepository.countByDate(date);
		return numBookingsOnThisDate;
	}


	@Override
	public Collection<Booking> findByUserId(Long userId) {
		Collection<Booking> booking = bookingRepository.findByUserId(userId);		
		return booking;
		}

	
	

}