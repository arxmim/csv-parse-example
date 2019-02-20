package ru.rgs.csvparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import ru.rgs.csvparser.configuration.MainConfiguration;

/**
 * @author ianazarov
 * (c) RGS
 * created 2019-02-19
 */
@EnableFeignClients
@SpringBootApplication
@Import(MainConfiguration.class)
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
