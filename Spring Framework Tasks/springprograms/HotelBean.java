package springprograms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//bean class
//NO XML FILE!!!!!!!!!!!!!!!!!!!!!!!!
@Component("HotelSpringAnnotation")//it is similar to the <bean id="HotelSpringAnnotation">::::::::Bean object reference

public class HotelBean {
	@Value("ExecutiveRoom")	
	String roomtype;
	@Value("Dry Cleaning,Flower Arrangements")
	String services;
	@Value("Occupied")
	String status;

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
