package springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springpojos.Item;
import springmain.AppConfig;

public class ItemMain {
    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Item item = context.getBean(Item.class);
        item.display();
    }
}
