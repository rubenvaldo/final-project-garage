package ie.cct.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.cct.springboot.service.BookingService;
import ie.cct.springboot.web.dto.UserBookingDto;

@Controller
@RequestMapping("/booking")
public class UserBookingController {
	
	private BookingService bookingService;

	public UserBookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@ModelAttribute("booking")
	public UserBookingDto userBookingDto() {
		return new UserBookingDto();
		
	}
	
	@GetMapping
	public String showBookingForm() {
		return "booking";
	}
	
	@PostMapping
	public String registerUserBooking(@ModelAttribute("booking") UserBookingDto bookingDto) {
		//UserBookingDto bookingDto = null;
		bookingService.save(bookingDto);
		return "redirect:/booking?success";
		
	}

}
