package mymainfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mypojos.Student_123;

public class HQLDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();//transient life cycle state
		
		Session sobj=sessionFactory.openSession();//create a session object
	
		//HQL COMMAND 1::
		String query1="from Student_123";//no table name! only pojo/entityO class name
		//HQL QUERY IS CREATED!
		Query q1=sobj.createQuery(query1);//Query is a interface(list(), scroll() or iterate())
		List<Student_123>  lobj1=q1.list();//LIST OR SELECT  ALL RECORDS
		for(Student_123 j:lobj1)
		{
					System.out.println(j.getId() + " "+j.getName() + " "+j.getEmail() );
		}
		System.out.println(" ------------------- ");
		
		
		//HQL COMMAND 2::
		String query11="select id,name,email from Student_123";//no table name! only pojo class name
		//HQL QUERY IS CREATED!
		Query q11=sobj.createQuery(query11);//Query is a interface(list(), scroll() or iterate())
		List<Object[]>  rows=q11.list();//LIST OR SELECT  ALL RECORDS
		for (Object[] row: rows) 
		{
		System.out.println(row[0] + " "+row[1]+ " "+row[2]);
		}

		//String q ="from Student_123 where id=?";//DYNAMIC HQL(OLDER VERSION(DEPRECATED)
		
		//select * from Student_123 where id=?
		String q ="from Student_123 where id=:abcd";//DYNAMIC HQL(Latest VERSION)
		Query q4 = sobj.createQuery(q);
		System.out.println("Enter the Studentno:");
		Scanner s1 = new Scanner(System.in);
		int pno11 = s1.nextInt();
		//q4.setInteger(0,pno11);//? =>0th position DYNAMIC HQL(OLDER VERSION(DEPRECATED)
		q4.setInteger("abcd",pno11);//latest=>//DYNAMIC HQL(Latest VERSION)

		List l2 = q4.list();
		Student_123 obj21 = (Student_123) l2.get(0);
		System.out.println("Student name & Email: " + obj21.getName()+ " " + obj21.getEmail());

		//HQL join examples
		/*eX: MYSQL left outer join::
		 * 
		 * SELECT Employee.EmployeeID, FullName, Department, Gender, ProjectName
FROM Employee 
LEFT OUTER JOIN Projects 
ON Employee.EmployeeID = Projects.EmployeeId;
		 */

		Query qry= sobj.createQuery("select ve.vid1, ve.vname1, ve.vemail,g1.custid,g1.custname from VendorPOJO ve left join ve.customers g1");
		List<Object[]> groupList = qry.list();
		for(Object[] arr : groupList){
			System.out.println(Arrays.toString(arr));
		}

		sobj.close();//detached state-End the session and releasing the JDBC Connection and clean up


	}

}
