package springprograms;

import java.util.List;
import java.util.Map;
import java.util.Set;

//Bean class
public class Vendor 
{
	//6 Bean Properties

	int vendorid;
	String vendorname;

	List<String> customername;//setter bean property is a collection type
	Set<String> branches;//setter bean property is a collection type

	Map<String,String> itemsdata;//key,value...//setter bean property is a collection type

	List<Supplier> slist;//setter bean with collection dependent object
	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public List<String> getCustomername() {
		return customername;
	}

	public void setCustomername(List<String> customername) {
		this.customername = customername;
	}

	public Set<String> getBranches() {
		return branches;
	}

	public void setBranches(Set<String> branches) {
		this.branches = branches;
	}

	public Map<String, String> getItemsdata() {
		return itemsdata;
	}

	public void setItemsdata(Map<String, String> itemsdata) {
		this.itemsdata = itemsdata;
	}

	public List<Supplier> getSlist() {
		return slist;
	}

	public void setSlist(List<Supplier> slist) {
		this.slist = slist;
	}


	

}
