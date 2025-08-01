package mypojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wipro_bi_customer")
public class CustomerBidirectionalPOJO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
    private int customerId;
	
	@Column(name = "customername",length=15)
	private String customerName;

	/*
	 * @ManyToOne: Each customer is associated with one vendor.

@JoinColumn(name = "vendor_id"): This creates the foreign key column in the customer table, 
linking it to the vendor table.
	 */
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private VendorBidirectionalPOJO vendor;
    
    // Getters and Setters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public VendorBidirectionalPOJO getVendor() { return vendor; }
    public void setVendor(VendorBidirectionalPOJO vendor) { this.vendor = vendor; }


}
