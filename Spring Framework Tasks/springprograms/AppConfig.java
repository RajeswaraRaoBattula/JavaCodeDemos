package springprograms;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springpojos.DormRoom;

@Configuration
@ComponentScan(basePackages = {"springpojos"})
public class AppConfig {

    @Bean(name = "mainDorm")
    public DormRoom dorm1() {
        return new DormRoom(101, "Maple Hall");
    }

    @Bean(name = "altDorm")
    public DormRoom dorm2() {
        return new DormRoom(202, "Oak Hall");
    }
}
