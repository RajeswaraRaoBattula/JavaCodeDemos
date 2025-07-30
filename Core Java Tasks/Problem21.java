/*
 * Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). 
 * Create subclasses Athlete and LazyPerson that extend the Person class and implement 
 * the respective methods to describe how each person eats and exercises.
 */
package myjavacodes;

abstract class Person{
	String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public abstract void eat();
	public abstract void exercise();
}

class Athelete extends Person{
	
	
	public Athelete(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void eat() {
		System.out.println(name+ " is eating healthy food..");
	}
	
	public void exercise() {
		System.out.println(name+" do exercise every day and he is very fit.");
	}
}

class LazyPerson extends Person{
	
	
	public LazyPerson(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void eat() {
		System.out.println(name+ " is  not eating healthy food..");
	}
	
	public void exercise() {
		System.out.println(name+" didn't  exercise every day so he is not fit.");
	}
}

public class Problem21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1=new Athelete("Raja");
		Person p2=new LazyPerson("Rajeswar");
		
		p1.eat();
		p1.exercise();
		
		p2.eat();
		p2.exercise();

	}

}
