package com.example.demo.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CustomerConfiguration {

//    @Bean
    public CustomerService customerService() {
        // setup and configure bean before creation
        // https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/howto-data-access.html#howto-configure-a-datasource
        return new CustomerService(
                new CustomerFakeRepository()
        );
    }
}
