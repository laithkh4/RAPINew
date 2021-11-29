package com.first.rapi;

import com.first.rapi.domain.Employee;
import com.first.rapi.domain.Order;
import com.first.rapi.domain.Status;
import com.first.rapi.repositories.EmployeeRepository;
import com.first.rapi.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", " Baggins", "burglar")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", " Baggins", "thief")));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}