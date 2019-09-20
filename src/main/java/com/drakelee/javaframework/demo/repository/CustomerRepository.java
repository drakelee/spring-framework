package com.drakelee.javaframework.demo.repository;

import java.util.List;

import com.drakelee.javaframework.demo.po.CustomerPO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerPO, String> {
    public CustomerPO findByFirstName(String firstName);
    public List<CustomerPO> findByLastName(String lastName);
}