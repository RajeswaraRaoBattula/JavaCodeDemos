package mymainfiles;

import java.util.Scanner;

import mydaodemos.VendorBidirectionalDAO;
import mypojos.CustomerBidirectionalPOJO;
import mypojos.VendorBidirectionalPOJO;
/*
 * mysql> select * from wipro_bi_vendor;
+----------+------------+
| vendorno | vendorname |
+----------+------------+
|     1900 | Zebronics  |
+----------+------------+
1 row in set (0.00 sec)

mysql> select * from wipro_bi_customer;
+------------+--------------+-----------+
| customerid | customername | vendor_id |
+------------+--------------+-----------+
|          1 | devi         |      1900 |
|          2 | abi          |      1900 |
|          3 | Priya        |      1900 |
+------------+--------------+-----------+
3 rows in set (0.00 sec)


AFTER DELETING CUSTOMER ID:

mysql> select * from wipro_bi_vendor;
+----------+------------+
| vendorno | vendorname |
+----------+------------+
|     1900 | Zebronics  |
+----------+------------+
1 row in set (0.00 sec)

mysql> select * from wipro_bi_customer;
+------------+--------------+-----------+
| customerid | customername | vendor_id |
+------------+--------------+-----------+
|          1 | devi         |      1900 |
|          2 | abi          |      1900 |
+------------+--------------+-----------+
2 rows in set (0.00 sec)
 */
public class OnetoManyBidirectionalCRUD {

	public static void main(String[] args) {
		VendorBidirectionalDAO dao = new VendorBidirectionalDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Vendor with Customers");
            System.out.println("2. View All Vendors");
            System.out.println("3. Delete Customer from Vendor");
            System.out.println("4. Update Customer Name");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
            case 1:
            	VendorBidirectionalPOJO v = new VendorBidirectionalPOJO();
                System.out.print("Enter Vendor ID: ");
                v.setVendorno(sc.nextInt());
                System.out.print("Enter Vendor Name: ");
                v.setVendorName(sc.next());

                System.out.print("How many customers? ");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                	CustomerBidirectionalPOJO c = new CustomerBidirectionalPOJO();
                    System.out.print("Enter Customer Name: ");
                    c.setCustomerName(sc.next());
                    v.addCustomer(c);
                }
                dao.addVendorWithCustomers(v);
                break;

            case 2:
                dao.viewAllVendors();
                break;

            case 3:
                System.out.print("Enter Vendor ID: ");
                int vid = sc.nextInt();
                System.out.print("Enter Customer ID to delete: ");
                int cid = sc.nextInt();
                dao.deleteCustomerFromVendor(vid, cid);
                break;

            case 4:
                System.out.print("Enter Customer ID: ");
                int custId = sc.nextInt();
                System.out.print("Enter New Name: ");
                String newName = sc.next();
                dao.updateCustomerName(custId, newName);
                break;

            case 5:
                System.out.println("Exiting...");
                //sc.close();
                //System.exit(0);
        }
    }

	}

}
