package ie.cct.springboot.model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Booking { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String make;
	private String type;
	private String licence_plate;
	private String engine_type;
	private String service_type;
	private String comment;



	private String date;
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) 
	private User user;
	
	//private Long user_id;
	
	
	public Booking() {
		//super();
	}
	
	


	public Booking(String make, String type, String licence_plate, String engine_type, String service_type,
			String comment, String date, User user) {
		super();
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.comment = comment;
		this.date = date;
		this.user = user;
		
	}




	public Booking(String make, String type, String licence_plate, String engine_type, String service_type,
			String date) {
		super();
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.date = date;
	}



/*
	public Booking(Long id, String make, String type, String licence_plate, String engine_type, String service_type,
			String date, User user) {
		super();
		this.id = id;
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.date = date;
		this.user = user;
	}
*/



	public Booking(String make, String type, String licence_plate, String engine_type, String service_type, 
			String date, User user) {
		super();
		//this.id = id;
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.date = date;
		this.user = user;
	}




	


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLicence_plate() {
		return licence_plate;
	}


	public void setLicence_plate(String licence_plate) {
		this.licence_plate = licence_plate;
	}


	public String getEngine_type() {
		return engine_type;
	}


	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}


	public String getService_type() {
		return service_type;
	}


	public void setService_type(String service_type) {
		this.service_type = service_type;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}




	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}