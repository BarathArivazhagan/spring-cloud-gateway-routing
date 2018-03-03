package com.barath.vodaphone.app.service;

import com.barath.vodaphone.app.entity.Customer;
import com.barath.vodaphone.app.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

/**
 * Created by barath on 03/03/18.
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

        customerRepository.saveAll(Arrays.asList(new Customer("barath-vodaphone", 25, Customer.CustomerGender.MALE)));
    }
}
