package com.barath.vodaphone.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by barath on 03/03/18.
 */
@Entity
@Table(name = "CUSTOMER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @GeneratedValue
    @JsonIgnore
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_NAME",nullable = false,length = 100)
    private String customerName;

    @Column(name = "CUSTOMER_AGE",nullable = false,length = 3)
    private int customerAge;


    @Enumerated(EnumType.STRING)
    @Column(name = "CUSTOMER_GENDER",length = 10)
    private CustomerGender customerGender;

    public enum CustomerGender{
            MALE,FEMALE
    }

    public Customer(Long customerId, String customerName, int customerAge, CustomerGender customerGender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
    }

    public Customer(String customerName, int customerAge, CustomerGender customerGender) {
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
    }

    protected Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public CustomerGender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(CustomerGender customerGender) {
        this.customerGender = customerGender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", customerGender=" + customerGender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerAge != customer.customerAge) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;
        return customerGender == customer.customerGender;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + customerAge;
        result = 31 * result + (customerGender != null ? customerGender.hashCode() : 0);
        return result;
    }
}
