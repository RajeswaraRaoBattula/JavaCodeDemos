package mydaodemos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mypojos.CustomerBidirectionalPOJO;
import mypojos.VendorBidirectionalPOJO;

public class VendorBidirectionalDAO {
	   private SessionFactory factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();

	    public void addVendorWithCustomers(VendorBidirectionalPOJO v) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(v);//insert vendor
	        tx.commit();
	        session.close();
	    }
	    public void viewAllVendors() {
	        Session session = factory.openSession();
	        List<VendorBidirectionalPOJO> vendorList = session.createQuery("from VendorBidirectionalPOJO").list();

        	for (Object obj : vendorList) {
        	    VendorBidirectionalPOJO v = (VendorBidirectionalPOJO) obj;
        	    System.out.println("Vendor: " + v.getVendorName());
        	    for (CustomerBidirectionalPOJO c : v.getCustomers()) {
        	        System.out.println("  - Customer: " + c.getCustomerName() + " (ID: " + c.getCustomerId() + ")");
        	    }
        	}

        session.close();
    }

	    public void deleteCustomerFromVendor(int vendorId, int customerId) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        VendorBidirectionalPOJO v = (VendorBidirectionalPOJO)session.get(VendorBidirectionalPOJO.class, vendorId);
	        if (v != null) {
	        	CustomerBidirectionalPOJO toRemove = null;
	            for (CustomerBidirectionalPOJO c : v.getCustomers()) {
	                if (c.getCustomerId() == customerId) {
	                    toRemove = c;
	                    break;
	                }
	            }
	            if (toRemove != null) {
	                v.removeCustomer(toRemove);//remove arraylist
	                session.update(v);//permanent deleting the customer child record
	            }
	        }
	        tx.commit();
	        session.close();
	    }

	    public void updateCustomerName(int customerId, String newName) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        CustomerBidirectionalPOJO c = (CustomerBidirectionalPOJO)session.get(CustomerBidirectionalPOJO.class, customerId);
	        if (c != null) {
	            c.setCustomerName(newName);
	            session.update(c);
	        }
	        tx.commit();
	        session.close();
	    }


	    
}
