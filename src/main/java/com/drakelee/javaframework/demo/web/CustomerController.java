package com.drakelee.javaframework.demo.web;

import java.util.List;
import java.util.Optional;

import com.drakelee.javaframework.demo.po.CustomerPO;
import com.drakelee.javaframework.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository) {
        customerRepository = this.customerRepository;
    }

    @RequestMapping("/customers")
    public List<CustomerPO> listCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public CustomerPO createCustomer(@RequestBody CustomerPO customerPO) {
        return customerRepository.insert(customerPO);
    }

    @PutMapping("/customers/{id}")
    public CustomerPO updateCustomer(@PathVariable String id, @RequestBody CustomerPO customerPO) {
        if (!customerExists(id)) { 
            throw new IllegalArgumentException(String.format("Customer with id={} does not exist.", id));
        }

        return customerRepository.save(customerPO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable String id) {
        if (!customerExists(id)) { 
            throw new IllegalArgumentException(String.format("Customer with id={} does not exist.", id));
        }

        customerRepository.deleteById(id);
    }

    private boolean customerExists(String id) {
        Optional<CustomerPO> existingCustomer = customerRepository.findById(id);
        return existingCustomer.isPresent();
    }
}