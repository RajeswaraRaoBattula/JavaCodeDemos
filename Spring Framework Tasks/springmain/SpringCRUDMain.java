package springmain;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daofiles.VehicleJDBCDAO;
import springprograms.VehicleJDBCBean;

public class SpringCRUDMain {

	public static void main(String[] args) {
	       ApplicationContext context = new ClassPathXmlApplicationContext("WIPROIOCContainer.xml");
	        VehicleJDBCDAO dao = (VehicleJDBCDAO) context.getBean("vehicleDao");
	        Scanner sc = new Scanner(System.in);
	        while (true) {
	            System.out.println("\n1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit");
	            System.out.print("Choose: ");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    VehicleJDBCBean v1 = new VehicleJDBCBean();
	                    System.out.print("ID: ");
	                    v1.setId(sc.nextInt());
	                    sc.nextLine();
	                    System.out.print("Model: ");
	                    v1.setModel(sc.nextLine());
	                    System.out.print("Color: ");
	                    v1.setColor(sc.nextLine());
	                    System.out.print("Year: ");
	                    v1.setYear(sc.nextInt());
	                    dao.insertVehicle(v1);
	                    System.out.println("Inserted.");
	                    break;

	                case 2:
	                	VehicleJDBCBean v2 = new VehicleJDBCBean();
	                    System.out.print("ID to Update: ");
	                    int i11=sc.nextInt();
	                    v2.setId(i11);
	                    sc.nextLine();
	                    System.out.print("New Model: ");
	                    v2.setModel(sc.nextLine());
	                    System.out.print("New Color: ");
	                    v2.setColor(sc.nextLine());
	                    System.out.print("New Year: ");
	                    v2.setYear(sc.nextInt());
	                    VehicleJDBCBean vehicle = dao.getVehicle(i11);
	                    if (vehicle == null) {
	                        System.out.println("Vehicle ID not found");
	                    } else {
	                        dao.updateVehicle(v2);
	                           System.out.println("Updated successfully");
	                    }  break;

	                case 3:
	                    System.out.print("ID to Delete: ");
	                    int id = sc.nextInt();
	                    VehicleJDBCBean vehicle_1 = dao.getVehicle(id);
	                    if (vehicle_1 == null) {
	                        System.out.println("Vehicle ID not found");
	                    } else {
	                        dao.deleteVehicle(id);
	                        System.out.println("Deleted successfully");
	                    }
	                    break;

	                case 4:
	                    System.out.print("ID to View: ");
	                    int id2 = sc.nextInt();
	                    VehicleJDBCBean v = dao.getVehicle(id2);
	                    if (v == null) {
	                        System.out.println("Vehicle ID not found");
	                    } else {
	                   
	                    System.out.println(v);
	                    }
	                    break;

	                case 5:
	                    List<VehicleJDBCBean> list = dao.getAllVehicles();
	                    list.forEach(System.out::println);
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    //sc.close();
	                    //System.exit(0);
	            }
	        }
	    }
	}
/*
Jul 31, 2025 3:56:00 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@bebdb06: startup date [Thu Jul 31 15:56:00 IST 2025]; root of context hierarchy
Jul 31, 2025 3:56:00 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [WIPROIOCContainer.xml]
Jul 31, 2025 3:56:01 PM org.springframework.jdbc.datasource.DriverManagerDataSource setDriverClassName
INFO: Loaded JDBC driver: com.mysql.jdbc.Driver

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 5
Vehicle [ID=1900, Model=HyundaiCreta, Color=White, Year=2024]

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 2
ID to Update: 1900
New Model: HyundaiAlcazar
New Color: black
New Year: 2025
Updated successfully

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 5
Vehicle [ID=1900, Model=HyundaiAlcazar, Color=black, Year=2025]

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 2
ID to Update: 4545
New Model: aaa
New Color: bbb
New Year: 333
Vehicle ID not found

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 3
ID to Delete: 5654
Vehicle ID not found

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 5
Vehicle [ID=1900, Model=HyundaiAlcazar, Color=black, Year=2025]

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 1
ID: 1888
Model: TataNexon
Color: White
Year: 2024
Inserted.

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 5
Vehicle [ID=1888, Model=TataNexon, Color=White, Year=2024]
Vehicle [ID=1900, Model=HyundaiAlcazar, Color=black, Year=2025]

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 3
ID to Delete: 1888
Deleted successfully

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 5
Vehicle [ID=1900, Model=HyundaiAlcazar, Color=black, Year=2025]

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: 6
Exiting...

1. Insert  2. Update  3. Delete  4. View One  5. View All  6. Exit
Choose: */