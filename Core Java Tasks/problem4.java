package myjavacodes;
//import java.util.*;
import java.util.Scanner;

public class problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name::");
		String name=sc.next();
		System.out.print("Enter Roll Number::");
		int roll_number=sc.nextInt();
		System.out.println("Enter Field of interest::");
		String field=sc.next();
		
		System.out.println("Hey, my name is "+name+" and my roll number is "+roll_number+". My Field of interest are "+field);
		sc.close();

	}

}
