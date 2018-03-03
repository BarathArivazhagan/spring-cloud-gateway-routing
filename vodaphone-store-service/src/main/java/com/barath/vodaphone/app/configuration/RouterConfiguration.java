package com.barath.vodaphone.app.configuration;

import com.barath.vodaphone.app.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


/**
 * Created by barath on 03/03/18.
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
