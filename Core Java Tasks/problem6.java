package myjavacodes;
import java.util.Scanner;

public class problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter marks::");
		int marks=sc.nextInt();
		if (marks >80) System.out.println("A");
		else if (marks > 60) System.out.println("B");
		else if (marks > 50) System.out.println("C");
		else if (marks > 45) System.out.println("D");
		else if (marks > 25) System.out.println("E");
		else System.out.println("F");
		sc.close();
	}

}
