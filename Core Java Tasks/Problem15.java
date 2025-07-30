/*15.Write a program to construct an array with 10 elements and to find the number of    
occurrences of each element in the Array.
*/

package myjavacodes;
//import java.util.Scanner;

public class Problem15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc=new Scanner(System.in);
		int[] arr=new int[10];
		for (int i=0; i<10; i++) {
			arr[i]=sc.nextInt(); 
		}
		for (int i=0; i<10; i++) {
			System.out.print(arr[i]+" ");
			
		}
		*/
		
		int[] arr={2,3,4,3,5,7,2,3,1,5};
		int[] freq=arr;
		int n=arr.length;
		//int[] freq=new int [10];
		int visited=-1;
		for (int i=0; i<n; i++) {
			int count =1;
			for (int j=i+1; j<n; j++) {
				if(arr[i]==arr[j]) {
					count++;
					freq[j]=visited;
				}	
			}
			if (freq[i]!=visited) {
				freq[i]=count;
			}
			
		}
		for (int i=0; i<freq.length; i++) {
			if (freq[i]!=visited) {
				System.out.println(arr[i]+" Occurs: "+freq[i]+" times.");
				
			}
		
			
		}
		
	}

}
