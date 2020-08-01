package ie.cct.springboot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cct.springboot.model.Booking;
import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.BookingRepository;
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
		
		Booking booking = new Booking(bookingDto.getId(), bookingDto.getMake(), bookingDto.getType(), 
				bookingDto.getLicence_plate(), bookingDto.getEngine_type(),
				bookingDto.getService_type(), bookingDto.getDate(), new User());
		
		/*
		Booking booking = new Booking(bookingDto.getMake(), bookingDto.getType(), 
				bookingDto.getLicence_plate(), bookingDto.getEngine_type(),
				bookingDto.getService_type(), bookingDto.getDate(), new User()); // need to double check
		*/
		return bookingRepository.save(booking);
				
	}

}
