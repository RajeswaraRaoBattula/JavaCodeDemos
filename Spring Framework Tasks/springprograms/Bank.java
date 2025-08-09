package springprograms;

public class Bank {
	String bankname;
	String managername;
	//Bank has a Branch!(Association or Composition)
	Branch bobj;//Setter Injection Type Dependent Object

	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}

	public Branch getBobj() {
		return bobj;
	}
	public void setBobj(Branch bobj) {
		this.bobj = bobj;
	}		


}
