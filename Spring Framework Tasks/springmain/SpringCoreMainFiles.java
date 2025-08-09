package springmain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springprograms.Bank;
import springprograms.Bank_AutoWireAnno;
import springprograms.Employee_ConstructorInjection;
import springprograms.HotelBean;
import springprograms.Patient;
import springprograms.Person;
import springprograms.ProjectData_Properties;
import springprograms.SampleBean;
import springprograms.Student_Course;
import springprograms.Supplier;
import springprograms.UserData;
import springprograms.Vendor;

public class SpringCoreMainFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext beanfactoryobj12 = new ClassPathXmlApplicationContext("WiproIOCContainer.xml");// src/main/resources);

		// SampleBean obj=new SampleBean();//not neccessary in SPRING

		// detect bean object OR lookup the bean in IOC
		SampleBean b1 = (SampleBean) beanfactoryobj12.getBean("mybean1");// bean object or bean id
		System.out.println("Welcome Spring By:: " + b1.getUsername());
	
		Student_Course b21 = (Student_Course) beanfactoryobj12.getBean("mybean3");// bean object=>2+2=4bean properties
		System.out.println("Student Data:: " + b21.getSid() + " " + b21.getSname() + " " + b21.getCourseid() + " "
				+ b21.getCoursename());
		
		System.out.println("REF Attribute(Setter Injection)::::::::::::");
		Bank b35 = (Bank) beanfactoryobj12.getBean("mybank_1");// LOOSELY COUPLED bean object
		System.out.println("Bank Data:: " + b35.getBankname() + " " + b35.getManagername() + " "
				+ b35.getBobj().getCity() + " " + b35.getBobj().getState());

		System.out.println("Without REF Attribute(Setter Injection(Inner /Nested Beans)::::::::::::");
		Bank b36 = (Bank) beanfactoryobj12.getBean("mybank_2");// TYGHLTY COUPLED bean object
		System.out.println("Bank Data:: " + b36.getBankname() + " " + b36.getManagername() + " "
				+ b36.getBobj().getCity() + " " + b36.getBobj().getState());


		System.out.println("Setter Collection DI::: ");
		Vendor ba85 = (Vendor) beanfactoryobj12.getBean("veobj");
		System.out.println("Vendor:: " + ba85.getVendorid() + " " + ba85.getVendorname());

		List<String> b6 = ba85.getCustomername();
		for (String s : b6) {
			System.out.println("Customers:: " + s);
		}

		Set<String> y1 = ba85.getBranches();
		for (String s : y1) {
			System.out.println("Branches:: " + s);
		}

		Map<String, String> y5 = ba85.getItemsdata();

		System.out.println("Items::(Key&Value)::");
		for (Map.Entry<String, String> uobj : y5.entrySet()) {
			System.out.println(uobj.getKey() + " " + uobj.getValue());
		}
		
		List<Supplier> sy3 = ba85.getSlist();
		for (Supplier s : sy3) {
			System.out.println("Suppliers:: " + s.getSupplierid() + " " + s.getSuppliername());
		}
		
		System.out.println("\n\nConstructor Injection:::::::::::::::::");
		// Constructor Injection
		Employee_ConstructorInjection emcons = (Employee_ConstructorInjection) beanfactoryobj12.getBean("myempsobj");
		System.out.println(emcons);// toString()

		List<String> rt1 = emcons.projects;
		for (String t : rt1) {
			System.out.println("Project List:: " + t);
		}
		Map<Integer, String> mp = emcons.certifications;
		for (Map.Entry<Integer, String> s12 : mp.entrySet()) {
			System.out.println("Certificate List:: " + s12.getKey() + " " + s12.getValue());
		}
		// AnnotationConfigApplicationContext to build a standalone Spring application.
		// Annotation Based Spring Application
		// AbstractApplicationContext is a interface
		// AnnotationConfigApplicationContext is a built in class!
	
		// #SOLUTION :: 1
			
		AbstractApplicationContext context1 = new AnnotationConfigApplicationContext(Patient.class);// loading spring bean
		Patient p1 = (Patient) context1.getBean("PatientBeanObj_1222");
		System.out.println("Patient:: " + p1.getPatientid() + " " + p1.getPatientname() + " " + p1.getDoctorname());

		// #SOLUTION :: 2
		// NO XML FILE BUT USING ANNOTATIONS!!!!!!!!!!!!
		// CONTEXT.XSD(component scanning) REQUIRED
		// <context:component-scan base-package="springprograms"/>

		HotelBean ht5 = (HotelBean) beanfactoryobj12.getBean("HotelSpringAnnotation");
		System.out.println("Hotel(@Component):: " + ht5.getRoomtype() + " " + ht5.getServices() + " " + ht5.getStatus());

		// XML-PROPERTIES FILE
				UserData ht56 = (UserData) beanfactoryobj12.getBean("user_obj1");
				System.out.println("User(PropertiesFile):: " + ht56.getUsername() + " " + ht56.getCompanyname() + " "
						+ ht56.getDomain() + " " + ht56.getAddress());

				//COMPLETE ANNOTATION-PROPERTIES FILE
				AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(ProjectData_Properties.class);
				ProjectData_Properties p11 = (ProjectData_Properties) context2.getBean("ProjectBeanObj");
				System.out.println("Project(Properties file):: " + p11.getClientname() + " " + p11.getSpecialization() + " "
						+ p11.getTeamsize() + " ");
				System.out.println("ConstructorInjection@Value:: " + p11.data6);
				List<String> yu = p11.getLanguages();
				System.out.println("Size: " + yu.size());
				for (String y : yu) {
					System.out.println("Languages:: " + y);
				}
		/*
		 * Autowiring is when Spring automatically injects the required dependency into a bean, 
		 * without you explicitly specifying it in XML or Java config.
		 
		 | Feature                    | Autowiring                            | Non-Autowiring (Manual)          |
| -------------------------- | ------------------------------------- | -------------------------------- |
| **Dependency Injection**   | Automatic by Spring                   | Manual by developer              |
| **Configuration Required** | Minimal                               | XML/Java config required         |
| **Ease of Use**            | Easier, less code                     | More verbose                     |
| **Maintainability**        | High – less chance of error           | Lower – prone to config mistakes |
| **Testing**                | Easier to mock dependencies           | May require more setup           |
| **Types Supported**        | By type, by name, constructor         | Fully controlled                 |
| **Example Annotations**    | `@Autowired`, `@Inject`, `@Qualifier` | `<bean ref>`, `@Bean`, `setXxx()`    |

		 */
				// Autowiring Attribute =>ByName
				Bank b361 = (Bank) beanfactoryobj12.getBean("baobj_15");// bean object
				System.out.println("\nBank Data:: " + b361.getBankname() + " " + b361.getManagername() + " "
						+ b361.getBobj().getCity() + " " + b361.getBobj().getState());

				// Autowiring Annotation
				Bank_AutoWireAnno b61 = (Bank_AutoWireAnno) beanfactoryobj12.getBean("BankObj_1234");// bean object
				System.out.println("\nBank(Autowire Annotation):: " + b61.getBankname() + " " + b61.getMgrname() + " "
										+ b61.getB20().getCity() + " " + b61.getB20().getState());

				System.out.println("Autowiring ByType:::::::::::");
				Person ty11 = (Person) beanfactoryobj12.getBean("personobj");
				System.out.println("Person:: " + ty11.getPersonid() + " " + ty11.getPersonname() + " "
						+ ty11.getCarobj().getCarid() + " " + ty11.getCarobj().getCarname());




	}

}
