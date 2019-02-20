package ru.rgs.csvparser.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rgs.csvparser.service.CsvParserService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author ianazarov
 * (c) RGS
 * created 2019-02-19
 */
@Configuration
public class MainConfiguration {

    @Bean
    public CsvParserService csvParserService() {
        throw new NotImplementedException();
    }
}
