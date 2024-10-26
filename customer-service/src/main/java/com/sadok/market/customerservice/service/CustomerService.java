package com.sadok.market.customerservice.service;



import com.sadok.market.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Integer id);

    Customer getCustomerByEmail(String email);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Integer id, Customer updatedCustomer);

    void deleteCustomer(Integer id);
}