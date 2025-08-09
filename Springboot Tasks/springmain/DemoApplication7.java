package springmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application8.properties")
@ComponentScan(basePackages = {
    "springcontroller", "springpojos"
})
public class DemoApplication7 {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication7.class, args);
    }
}
