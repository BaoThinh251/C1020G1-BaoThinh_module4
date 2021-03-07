package opa.demo;

import opa.demo.log.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Config {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
