package com.drakelee.demo.config;

import static org.mockito.Mockito.mock;

import com.drakelee.javaframework.demo.repository.CustomerRepository;
import com.drakelee.javaframework.demo.web.CustomerController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
    @Bean
    @Primary
    public CustomerController customerController() { 
        return new CustomerController(customerRepository;
    }

    @Bean
    @Primary
    public CustomerRepository customerRepository() {
        return mock(CustomerRepository.class);
    }
}