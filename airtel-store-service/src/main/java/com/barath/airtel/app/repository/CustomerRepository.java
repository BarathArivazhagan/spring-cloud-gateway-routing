package com.barath.airtel.app.repository;

import com.barath.airtel.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author barath
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomerName(String customerName);

}
