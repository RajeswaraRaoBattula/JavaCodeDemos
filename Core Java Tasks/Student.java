package myjavacodes;
import java.util.Scanner;

public class Student {
	
	public static int counter=1;
	int roll_no;
	String name;
	int marksInEng;
	int marksInMaths;
	int marksInScience;
	
	public Student(String name, int marksInEng, int marksInMaths, int marksInScience) {
		this.roll_no=counter++;
		this.name=name;
		this.marksInEng=marksInEng;
		this.marksInMaths=marksInMaths;
		this.marksInScience=marksInScience;
	}
	

	public int getRoll_no() {
		return roll_no;
	}


	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarksInEng() {
		return marksInEng;
	}


	public void setMarksInEng(int marksInEng) {
		this.marksInEng = marksInEng;
	}


	public int getMarksInMaths() {
		return marksInMaths;
	}


	public void setMarksInMaths(int marksInMaths) {
		this.marksInMaths = marksInMaths;
	}


	public int getMarksInScience() {
		return marksInScience;
	}


	public void setMarksInScience(int marksInScience) {
		this.marksInScience = marksInScience;
	}
	
	public void display() {
		System.out.println("Roll No:" +roll_no);
		System.out.println("Name:" +name);
		System.out.println("marksInEng:" +marksInEng);
		System.out.println("marksInMaths:" +marksInMaths);
		System.out.println("marksInScience:"+marksInScience);
		System.out.println();
	}
	
	class Standard{
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Student s1=new Student("Raja",34,45,56);
		Student s2=new Student("Hari",23,78,89);
		s1.display();
		s2.display();
		
		sc.close();
	}

}
