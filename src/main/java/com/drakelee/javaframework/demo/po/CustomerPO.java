package com.drakelee.javaframework.demo.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class CustomerPO {
   
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public CustomerPO() {}

    @PersistenceConstructor
    public CustomerPO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%s, firstName='%s', lastName='%s']",
            id, firstName, lastName
        );
    }
}