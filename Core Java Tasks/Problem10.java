package myjavacodes;
import java.util.Scanner;
public class Problem10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int total_eggs=sc.nextInt();
		int gross=total_eggs/144;
		int dozen=(total_eggs%144)/12;
		int eggs=(total_eggs%144)%12;
		System.out.println("Your number of eggs is "+gross+" gross, "+ dozen+" Dozen, "+eggs+" eggs");
		sc.close();
	}

}
