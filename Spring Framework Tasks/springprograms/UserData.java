package springprograms;
/*
 * Why Use .properties Files?
Externalize configuration — no need to hardcode in Java files.

Easily editable without recompiling.

Supports environment-specific setups.

Used widely in Spring, Hibernate, Java SE, Java EE, etc.

A properties file is a simple key-value pair text file used to store configuration settings for 
Java applications — including Spring, Hibernate, JDBC, and more.
 */
//Bean class=>REFER IN .XML FILE
public class UserData {
	String username;//<property tag> in xml

	//for remaining these 3 properties , going to fetch the value from WIPROSettings.properties file

	String companyname;
	String address;
	String domain;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}

}
