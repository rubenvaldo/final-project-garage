package ie.cct.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.cct.springboot.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	//Booking findByLicence(String licence_plate);

}
