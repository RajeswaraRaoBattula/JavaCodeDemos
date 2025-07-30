/*
 * Five Bikers Compete in a race such that they drive at a constant speed which may or may
not be the same as the other. To qualify the race, the speed of a racer must be more than the
average speed of all 5 racers. Take as input the speed of each racer and print back the speed
of qualifying racers. 
 */
package house;
import java.util.Scanner;
import java.util.Arrays;
public class Race {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] speeds=new int[5];
		int sum=0;
		for (int i=0; i<=4; i++) {
			System.out.print("Enter Racer "+(i+1)+"'s speed:");
			speeds[i]=sc.nextInt();
			sum+=speeds[i];
		}
		System.out.println();
		int avg=sum/5;
		
		System.out.println("Speed of qualifying racers...");
		boolean isQualified=false;
		
		for (int sp:speeds) {
			if (sp >avg) {
				System.out.println(sp);
				isQualified=true;
			}
		}
		
		if (!isQualified) {
            System.out.println("No racer qualified.");
        }
		
		
		
		
	}

}
