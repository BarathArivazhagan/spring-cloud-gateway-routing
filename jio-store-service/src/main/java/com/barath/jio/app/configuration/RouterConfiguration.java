package com.barath.jio.app.configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.barath.jio.app.handler.CustomerHandler;


/**
 * @author barath
 */
@Configuration
public class RouterConfiguration {

    private CustomerHandler customerHandler;

    public RouterConfiguration(CustomerHandler customerHandler){
        this.customerHandler=customerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routes(){

        return RouterFunctions
                    .route(POST("/customer/add")
                            .and(accept(MediaType.APPLICATION_JSON_UTF8)),customerHandler::addCustomer)
                    .andRoute(GET("/customer/get/{customerName}"),customerHandler::getCustomer)
                    .andRoute(GET("/customers"),customerHandler::getCustomers);

    }
}
