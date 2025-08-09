package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springprograms.ShoppingService;

public class MainApp2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");

        ShoppingService service = context.getBean("shoppingService", ShoppingService.class);
        
        System.out.println("------- STARTING OPERATIONS -------");
        service.addToCart("Laptop");
        service.makePayment(49999.99);
        service.placeOrder();
    }
}
