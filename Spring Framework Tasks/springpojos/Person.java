package springpojos;

public class Person {
    private int id;
    private int age;
    private String firstName;
    private String lastName;

    // Constructors
    public Person() {}
    
    public Person(int id, int age, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters & Setters
    // toString()
    @Override
    public String toString() {
        return "Person{id=" + id + ", age=" + age + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters & Setters
    // ...
}

