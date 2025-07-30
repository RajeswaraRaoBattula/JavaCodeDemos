package mymavendemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentJDBCDemo {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro2025","root","Raja@0510");
			st=con.createStatement();
			rs=st.executeQuery("select * from Students");
			while(rs.next()) {
				int a=rs.getInt("ID");
				String b=rs.getString(2);
				int c=rs.getInt("age");
				String d=rs.getString("course");
				int e=rs.getInt("marks");
				
				System.out.println(a+ " "+b+ " "+c+" "+d+" "+e);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e) {
				System.out.println("Finally Block::"+e);
			}
		}
	}

}

/*
101 Raja 23 CSE 500
102 Murali 22 ECE 600
103 Jagadeesh 21 Civil 400
104 Basheer 23 AME 450
*/
