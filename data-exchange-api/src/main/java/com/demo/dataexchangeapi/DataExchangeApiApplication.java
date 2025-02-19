package com.demo.dataexchangeapi;

import com.demo.dataexchangeapi.properties.JwtProperties;
import com.demo.dataexchangeapi.properties.RabbitProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RabbitProperties.class, JwtProperties.class})
public class DataExchangeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataExchangeApiApplication.class, args);
    }

}
