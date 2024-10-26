package com.sadok.market.customerservice.service;


import com.sadok.market.customerservice.entity.Customer;
import com.sadok.market.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Customer with email " + email + " not found"));
    }


    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(updatedCustomer.getFirstName());
                    customer.setLastName(updatedCustomer.getLastName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
