package springprograms;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * Properties file can be loaded in 2 ways::
 * 1.XML file(Completed)
 * 2.Annotation
 */
/*
 * Spring @PropertySource annotation is used to provide properties file to Spring Environment. 
 * This annotation is used with @Configuration classes.
 */

@Configuration
@PropertySource({"classpath:ProjectConnect.properties"})//<<context:property-placeholder /> in xml 


@Component("ProjectBeanObj")
public class ProjectData_Properties 
{
	@Value("${ProjectClient}")	//${}=>placeholder
	String clientname;
	
	@Value("${TeamSize}")	
	String teamsize;
	
	@Value("${ProjectDomain}")
	String specialization;
	

	@Value("#{'${langlist}'.split(',')}")//no commas
	List<String> languages;

	public String data6;//feedback

	//Using @Value with Constructor Injection
	public ProjectData_Properties(
			@Value("${feedback}") 
			String data6) 
			{
				super();
				this.data6 = data6;
			}
	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(String teamsize) {
		this.teamsize = teamsize;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getData6() {
		return data6;
	}

	public void setData6(String data6) {
		this.data6 = data6;
	}


}
