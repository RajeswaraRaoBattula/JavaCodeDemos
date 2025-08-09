package springprograms;

import java.util.List;
import java.util.Map;

/*
| Feature                 | Constructor Injection                   | Setter Injection                           |
| ----------------------- | --------------------------------------- | ------------------------------------------ |
| **How it works**        | Injected via class constructor          | Injected via public setter method          |
| **When it's used**      | When all dependencies are **required**  | When some dependencies are **optional**    |
| **Immutability**        | Good for making the class **immutable** | Allows **changing values later**           |
| **Readability**         | Clear when many required fields         | Can be hard to read if too many setters    |
| **Partial injection**   | ❌ Not possible (requires all values)    | ✅ Possible (you can skip optional setters) |
| **Circular dependency** | May throw error in some cases           | Handles circular dependencies better       |
| **XML config example**  | `<constructor-arg>`                     | `<property>`                               |


| Feature              | Constructor Injection  | Setter Injection                 | Collection Injection               |
| -------------------- | ---------------------- | -------------------------------- | ---------------------------------- |
| Injects via          | Constructor            | Setter methods                   | Setter methods for collections     |
| Used for             | Mandatory dependencies | Optional / flexible dependencies | List, Set, Map, Properties         |
| Immutable            | Yes                    | No                               | No                                 |
| Syntax (XML)         | `<constructor-arg>`    | `<property>`                     | `<property><list> / <set> / <map>` |
| Object type injected | Single value or object | Single value or object           | Multiple values or objects         |
*/
//Bean class
public class Employee_ConstructorInjection {
	int eno;//index 0
	String ename;//index 1
	Address addrobj;//Constructor injection dependent object
	public List<String> projects;//Constructor injection with Collection
	public Map<Integer,String> certifications;//Constructor injection with Collection
	
	public Employee_ConstructorInjection(int eno, String ename, Address addrobj, List<String> projects,
			Map<Integer, String> certifications) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.addrobj = addrobj;
		this.projects = projects;
		this.certifications = certifications;
	}

	@Override
	public String toString() {
		return "Employee Data:: "+ eno + " " + ename + " " + addrobj.city + " "+addrobj.country;
	}

}
