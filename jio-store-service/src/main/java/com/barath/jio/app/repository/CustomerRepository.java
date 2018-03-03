package com.barath.jio.app.repository;

import com.barath.jio.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by barath on 03/03/18.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomerName(String customerName);

}
