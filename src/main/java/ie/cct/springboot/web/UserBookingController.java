
package ie.cct.springboot.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ie.cct.springboot.model.User;
import ie.cct.springboot.repository.UserRepository;
import ie.cct.springboot.service.BookingService;
import ie.cct.springboot.web.dto.UserBookingDto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;


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
	public String showBookingForm() { // when accessing localhost:XXXX/booking
		return "booking";
	}
	
	
/*	
    @GetMapping("mybookings")
    public String showMyBookings(Model model, Principal principal) {

 //       User user = userRepository.findByEmail(principal.getName());
  //      model.addAttribute("userBookings", bookingService.findByUserId(user.getId()));

        return "mybookings";
    }
	
*/	
	
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
    
	
	  

	@PostMapping
		public String registerUserBooking(@ModelAttribute("booking") UserBookingDto bookingDto, Errors errors, Principal principal) {
			
		
			User user = userRepository.findByEmail(principal.getName());
			bookingDto.setUser(user);
			
			int numExistingBookingSpaces = bookingService.getNumBookingsByDate(bookingDto.getDate());
			
			int maxBookings = 4;
			
			if (numExistingBookingSpaces == maxBookings) {
	            errors.rejectValue("date", null, "Sorry but the date you selected is fully booked");

	           // errors.popNestedPath();
//	            model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
//	            model.addAttribute("availableTime", time.getAvailableTime());
	        }
			
		

				if (errors.hasErrors()) {
					return "booking";
				}

			
			
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
	
	//Adapted from https://github.com/RameshMF/registration-login-spring-boot-security-thymeleaf-hibernate

}
