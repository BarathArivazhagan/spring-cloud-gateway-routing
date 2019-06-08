package com.barath.jio.app.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.barath.jio.app.entity.Customer;
import com.barath.jio.app.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author barath
 */
@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> addCustomer(Mono<Customer> customerMono){

        return customerMono
                    .doOnNext(customerRepository::save).doOnError( error -> {
                    logger.error("error in creating a customer {}",error.getMessage());
                });
    }

    public Mono<Customer> getCustomer(String customerName){

       return Mono.just(customerRepository.findByCustomerName(customerName));
    }

    public Flux<Customer> getCustomers(){

        return Flux.fromIterable(customerRepository.findAll()).log();
    }

    /**
     * pre load customers for testing for in memory DB
     */

    @PostConstruct
    public void init(){

        customerRepository.saveAll(Arrays.asList(new Customer("barath-jio", 25, Customer.CustomerGender.MALE)));
    }
}
