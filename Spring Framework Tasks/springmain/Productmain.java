package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springpojos.purchase;

public class Productmain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        purchase p = (purchase) context.getBean("purchaseBean");
        p.showDetails();
    }
}

