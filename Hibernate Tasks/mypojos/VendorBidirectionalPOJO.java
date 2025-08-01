package mypojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//ONE TO MANY BIDIRECTIONAL RELATIONSHIP
@Entity
@Table(name="wipro_bi_vendor")
public class VendorBidirectionalPOJO {
	 @Id
	    @Column(name = "vendorno")//primary key
		private int vendorno;
	    
	    @Column(name = "vendorname",length=15)
		private String vendorName;

	    /*
	     * mappedBy = "vendor" refers to the field name in CustomerBidirectionalPOJO.

	    orphanRemoval = true means: if you do vendor.getCustomers().remove(customer), Hibernate will delete that customer.

	    CascadeType.ALL means that persist, remove, merge, refresh, detach will cascade from Vendor to Customers.
	     */

	    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<CustomerBidirectionalPOJO> customers = new ArrayList<>();

	    public void addCustomer(CustomerBidirectionalPOJO c) {
	    	/*
	    	 * When you add a Customer to a Vendor, you must:

				1.Add the Customer to the Vendor’s customers list.
				2.Set the Vendor reference inside the Customer.

				This keeps both sides of the relationship synchronized, which is critical for Hibernate to:
					--Persist the relationship correctly.
					--Avoid issues like TransientPropertyValueException.
					--Enable proper cascading and orphanRemoval behavior.
	    	 */
	    	customers.add(c);
	        c.setVendor(this);
	    }

	    public void removeCustomer(CustomerBidirectionalPOJO c) {
	    	customers.remove(c);//Removes the Customer from the Vendor's list.
	        c.setVendor(null);//Breaks the link from the Customer back to the Vendor
	        //This Customer no longer belongs to this Vendor.
	        //If orphanRemoval = true, delete it from the database.
	    }

	    
	    // Getters and Setters
	    public int getVendorno() { return vendorno; }
	    public void setVendorno(int vendorno) { this.vendorno = vendorno; }
	    public String getVendorName() { return vendorName; }
	    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
	    public List<CustomerBidirectionalPOJO> getCustomers() { return customers; }
	    public void setCustomers(List<CustomerBidirectionalPOJO> customers) { this.customers = customers; }

}
