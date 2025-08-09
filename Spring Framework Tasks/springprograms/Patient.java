package springprograms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//bean class
//NO XML FILE!!!!!!!!!!!!!!!!!!!!!!!!
/*
* The @Component annotation marks the Java class as a bean or component so 
* that the component-scanning mechanism of 
* Spring can add it into the application context.
*/

@Component("PatientBeanObj_1222")//it is similar to the //<bean class="com.springprograms.Patient" id="PatientBeanObj_1222">::::::::Bean object reference
public class Patient {

	//INJECT THE VALUE TO THE BEAN PROPERTY

	//@Value annotation is equivalent to <property name="patientid" value="1001">

	@Value("1001")	//setPatientid(int)
	int patientid;

	@Value("Devi")//setPatientname(String)
	String patientname;

	@Value("Abi")//setDoctorname
	String doctorname;

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	

}
