package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springpojos.Account1;

public class AccountMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Account1 account = (Account1) context.getBean("accountBean1");
        account.display();
    }
}
