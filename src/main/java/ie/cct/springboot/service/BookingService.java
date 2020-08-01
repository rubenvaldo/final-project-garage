package ie.cct.springboot.service;

import ie.cct.springboot.model.Booking;
import ie.cct.springboot.web.dto.UserBookingDto;

public interface BookingService {
	Booking save(UserBookingDto bookingDto);

}
