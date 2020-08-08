
package ie.cct.springboot.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.UserRepository;
import ie.cct.springboot.service.BookingService;
import ie.cct.springboot.web.dto.UserBookingDto;


@Controller
@RequestMapping("/booking")
public class UserBookingController {
	
	private BookingService bookingService;
	
	@Autowired
	private UserRepository userRepository;

	public UserBookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	

	
	@ModelAttribute("booking") //<form th:action="@{/booking}" method="post" th:object="${booking}">
	public UserBookingDto userBookingDto() {
		return new UserBookingDto();
		
	}
	
	@GetMapping
	public String showBookingForm() {
		return "booking";
	}
	
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
    
	
	  

	@PostMapping
		public String registerUserBooking(@ModelAttribute("booking") UserBookingDto bookingDto, Principal principal) {
			User user = userRepository.findByEmail(principal.getName());
			bookingDto.setUser(user);
			bookingService.save(bookingDto);
			return "redirect:/booking?success";
			
		}
		
	/*
	@PostMapping
	public String registerUserBooking(@ModelAttribute("booking") UserBookingDto bookingDto, Principal principal) {
		//User user = new User();
		User user = userRepository.findByEmail(principal.getName());
		bookingService.save(bookingDto, user);
		return "redirect:/booking?success";
		
	}
	*/

}
