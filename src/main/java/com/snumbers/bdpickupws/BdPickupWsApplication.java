package com.snumbers.bdpickupws;

import com.snumbers.bdpickupws.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdPickupWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdPickupWsApplication.class, args);
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

}
