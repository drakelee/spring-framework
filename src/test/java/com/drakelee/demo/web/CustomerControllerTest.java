package com.drakelee.demo.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import com.drakelee.javaframework.demo.po.CustomerPO;
import com.drakelee.javaframework.demo.repository.CustomerRepository;
import com.drakelee.javaframework.demo.web.CustomerController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerControllerTest {

    private CustomerController customerController;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void getAllCustomers() {
        CustomerPO customerPO = new CustomerPO();
        List<CustomerPO> responseList = new LinkedList<CustomerPO>();
        responseList.add(customerPO);
        when(customerRepository.findAll()).thenReturn(responseList);

        List<CustomerPO> response = customerController.listCustomers();

        assertEquals(2, 1);
    }
}