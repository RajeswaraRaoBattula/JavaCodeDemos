package springmain;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springpojos.Freshman;
import springprograms.AppConfig;

public class AutoWired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("   AUTOWIRED ANNOTATION DEMO");
        System.out.println("===============================");
        System.out.println("Options:");
        System.out.println("1. Autowired");
        System.out.println("2. Autowired with Qualifier");
        System.out.print("Select option: ");
        int choice = sc.nextInt();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Freshman student = context.getBean(Freshman.class);

        switch (choice) {
            case 1:
                System.out.println("Autowiring without Qualifier:");
                student.showDetails();
                break;
            case 2:
                System.out.println("Autowiring with Qualifier:");
                student.showDetails();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();

	}

}
