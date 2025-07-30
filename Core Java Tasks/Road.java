/*
 * Create a class called Vehicle. Create subclasses like Truck, Bus, Car etc. Add common methods 
in the base class and specific methods in the corresponding class. Create a class called Road 
and create objects for the Truck, Car, Bus etc and display the appropriate message. 

In the Vehicle class constructor initialize few variables like color, no of 
wheels, model etc. Give appropriate values for these variables from the invoking subclass.
 */
package myjavacodes;

class Vehicle{
	String color;
	int no_of_wheels;
	String model;
	public Vehicle(String color, int no_of_wheels, String model) {
		super();
		this.color = color;
		this.no_of_wheels = no_of_wheels;
		this.model = model;
	}
	
	public void display() {
		System.out.println("Model: "+model);
		System.out.println("Color: "+color);
		System.out.println("Wheels: "+no_of_wheels);
	}
	
}

class Truck extends Vehicle{

	public Truck(String color, int no_of_wheels, String model) {
		super(color, no_of_wheels, model);
		// TODO Auto-generated constructor stub
	}
	public void truckDisplay() {
		System.out.println("Truck runs slowly..");
	}
	
}

class Bus extends Vehicle{

	public Bus(String color, int no_of_wheels, String model) {
		super(color, no_of_wheels, model);
		// TODO Auto-generated constructor stub
	}
	public void busDisplay() {
		System.out.println("Bus has average speed...");
	}
	
}

class Car extends Vehicle{
	public Car(String color, int no_of_wheels, String model) {
		super(color, no_of_wheels, model);
		// TODO Auto-generated constructor stub
	}
	public void carDisplay() {
		System.out.println("car has high speed...");
	}
}

public class Road {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck t1=new Truck("Black",10,"xyz1");
		Bus b1=new Bus("Red",6,"UltraDelus");
		Car c1=new Car("White",4,"Brezza");
		t1.display();
		t1.truckDisplay();
		
		System.out.println("------------");
		b1.display();
		b1.busDisplay();
		
		System.out.println("------------");
		c1.display();
		c1.carDisplay();
		
		

	}

}












