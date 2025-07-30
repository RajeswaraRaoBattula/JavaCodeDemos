/*
 * Write a Java program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). 
 * Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop 
 * the engines for each vehicle type.
 */
package myjavacodes;

abstract class Vehicle1{
	public abstract void startsEngine();
	public abstract void stopEngine();
}

class Car1 extends Vehicle1{
	@Override
	public void startsEngine() {
		System.out.println("The car is starting...");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("The car is stopped...");
	}
	
}

class Motorcycle extends Vehicle1{
	
	@Override
	public void startsEngine() {
		System.out.println("The bike is starting...");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("The bike is stopped...");
	}
	
}
public class Probleem20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle1 c1=new Car1();
		Vehicle1 b1=new Motorcycle();
		
		c1.startsEngine();
		c1.stopEngine();
		
		b1.startsEngine();
		b1.stopEngine();

	}

}
