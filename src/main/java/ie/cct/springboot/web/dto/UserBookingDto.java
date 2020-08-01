package ie.cct.springboot.web.dto;

import ie.cct.springboot.model.User;

public class UserBookingDto {
	
	private String make;
	private String type;
	private String licence_plate;
	private String engine_type;
	private String service_type;
	private String date;
	private Long Id;
	
	
	public UserBookingDto() {
		//super();
	}
	
	

	public UserBookingDto(String make, String type, String licence_plate, String engine_type, String service_type,
			String date, Long id) {
		super();
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.date = date;
		this.Id = id;
	}



	public UserBookingDto(String make, String type, String licence_plate, String engine_type, String service_type,
			String date) {
		super();
		this.make = make;
		this.type = type;
		this.licence_plate = licence_plate;
		this.engine_type = engine_type;
		this.service_type = service_type;
		this.date = date;
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



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		this.Id = id;
	}
	
	
	
	
	

	

}
