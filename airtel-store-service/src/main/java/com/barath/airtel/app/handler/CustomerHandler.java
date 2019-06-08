package com.barath.airtel.app.handler;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.barath.airtel.app.entity.Customer;
import com.barath.airtel.app.service.CustomerService;

import reactor.core.publisher.Mono;

/**
 * @author barath
 */
@Component
public class CustomerHandler {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private CustomerService customerService;

    public CustomerHandler(CustomerService customerService) {
        this.customerService=customerService;
    }

    public Mono<ServerResponse> addCustomer(ServerRequest serverRequest){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(customerService.addCustomer(serverRequest.bodyToMono(Customer.class)),Customer.class)
                .log();
    }

    public Mono<ServerResponse> getCustomer(ServerRequest serverRequest){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(customerService.getCustomer(serverRequest.pathVariable("customerName")),Customer.class)
                .log();
    }

    public Mono<ServerResponse> getCustomers(ServerRequest serverRequest){

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(customerService.getCustomers(),Customer.class)
                .log();
    }


}
