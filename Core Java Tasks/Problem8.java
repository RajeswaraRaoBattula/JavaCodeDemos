package myjavacodes;

import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc=new Scanner(System.in);
				System.out.print("Number of classes held :");
				int num=sc.nextInt();
				sc.nextLine();
				System.out.println("Number of Classes attended:");
				int att=sc.nextInt();
				double perc=((double)att/num)*100;
				System.out.println("Percentage of classes attended:"+perc);
				
				
				if (perc >=70) {
					System.out.println("Student is allowed to sit in exam hall...");
				}
				else {
					System.out.println("Do you have medical cause(Y/N):");
					sc.nextLine();
					char cause=sc.next().trim().toUpperCase().charAt(0);
					
					if (cause=='Y') {
						System.out.println("Student is allowed to sit in exam hall...");
					}
					else {
						System.out.println("Not allowed...");
					}
				}
				sc.close();

	}

}
