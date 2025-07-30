package myjavacodes;
import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Salary::");
		double salary=sc.nextDouble();
		System.out.print("Enter years of experience::" );
		int years=sc.nextInt();
		if (years>6) {
			double bonus=((double)salary)*((double)10/100);
			System.out.println(bonus);
			sc.close();
		}

	}

}
