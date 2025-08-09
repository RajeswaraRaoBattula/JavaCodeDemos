package springprograms;

/*
 * | Type                        | Description                                                     |
| --------------------------- | --------------------------------------------------------------- |
| `no` (default)              | No autowiring. Manual wiring is needed.                         |
| `byName`                    | Injects the bean whose **id/name matches** the property name.   |
| `byType`                    | Injects a bean **based on the type** of the property.           |
| `constructor`               | Injects the bean via **constructor based on type**.             |
| `autodetect` *(deprecated)* | Spring automatically chooses between `constructor` or `byType`. |

| Autowire Type | Works On           | Match Based On                                                 | Notes                                   |
| ------------- | ------------------ | -------------------------------------------------------------- | --------------------------------------- |
| `no`          | Manual wiring only | N/A                                                            | Default behavior                        |
| `byName`      | Setter or field    | Bean **id/name** matches property name                         | Prone to name mismatch errors           |
| `byType`      | Setter or field    | Bean **type** matches property type                            | Fails if more than one matching type    |
| `constructor` | Constructor only   | Type of constructor arguments                                  | Must have only one matching constructor |
| `autodetect`  | Constructor/setter | Automatically picks constructor if available, otherwise setter | Deprecated since Spring 3               |

 */
public class Person {
	int personid;
	String personname;
	Car carobj;//Person has a Car----has a relationship
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public Car getCarobj() {
		return carobj;
	}
	public void setCarobj(Car carobj) {
		this.carobj = carobj;
	}

}
