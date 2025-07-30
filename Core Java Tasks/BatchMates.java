/*
 * Write a program that creates a new file called batch mates and 
 * store your entire batch mates name in it and display the details.
 */
package myjavacodes;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BatchMates {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File f1=new File("D:\\Wipro_2025\\batchmates.txt");
		f1.createNewFile(); // IOException-checked exception
		
		FileWriter myWriter=new FileWriter("D:\\Wipro_2025\\batchmates.txt");
		myWriter.write("Raja Murali jagadesh Basheer Ganesh Ramya");
		myWriter.close();
		
		File obj=new File("D:\\Wipro_2025\\batchmates.txt");
		Scanner myReader=new Scanner(obj);
		while (myReader.hasNextLine()) {
			String data=myReader.nextLine();
			System.out.println(data);
		}
		
		

	}

}
