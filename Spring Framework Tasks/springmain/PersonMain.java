package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springconfig.AppConfig;
import springpojos.Person;
import springservice.PersonService;

public class PersonMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService service = context.getBean(PersonService.class);

        service.create(new Person(1, 21, "Vlad", "Boyarskiy"));
        service.create(new Person(2, 30, "Oksi", "Bahatskaya"));
        service.create(new Person(3, 32, "Vadim", "Vadimich"));

        System.out.println("List of person is:");
        service.readAll().forEach(System.out::println);

        System.out.println("\nGet person with ID 2");
        System.out.println(service.read(2));

        System.out.println("\nCreating person:");
        service.create(new Person(4, 36, "Sergey", "Emets"));

        System.out.println("\nList of person is:");
        service.readAll().forEach(System.out::println);

        System.out.println("\nDeleting person with ID 2");
        service.delete(2);

        System.out.println("\nUpdate person with ID 4");
        service.update(4, new Person(4, 36, "Sergey", "CHANGED"));

        System.out.println("\nList of person is:");
        service.readAll().forEach(System.out::println);
    }
}
