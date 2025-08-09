package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springpojos.Account;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Attempting to load context...");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       // System.out.println("Context loaded!");

        Account acc = (Account) context.getBean("accountBean");
       // System.out.println("Bean fetched!");
        acc.printDetails();
    }
}

/*
Account Number: 630198
Account Holder Name: Rajeswara Rao
Balance: 350000.0
Bank Details: Bank ID: 101, Bank Name: State Bank of India
*/