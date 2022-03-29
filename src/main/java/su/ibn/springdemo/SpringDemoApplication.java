package su.ibn.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import su.ibn.springdemo.services.HorseSound;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

        //получаем контекст и извлекаем из него bean по имени
        HorseSound catSound = (HorseSound) context.getBean("horseSound");
        System.out.println(catSound.sound());
    }
}
