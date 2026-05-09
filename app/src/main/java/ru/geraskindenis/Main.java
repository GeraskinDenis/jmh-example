package ru.geraskindenis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.geraskindenis.security.PasswordHasher;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        demo(context);
    }

    private static void demo(ConfigurableApplicationContext context) {
        PasswordHasher passwordHasher = context.getBean(PasswordHasher.class);

        String pass = "123qweads";
        System.out.printf("Pass: %s Hash: %s%n", pass, passwordHasher.hashPassword(pass));

        pass = "sdf43243";
        System.out.printf("Pass: %s Hash: %s%n", pass, passwordHasher.hashPassword(pass));
    }
}