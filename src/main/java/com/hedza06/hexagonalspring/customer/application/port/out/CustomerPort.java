package com.hedza06.hexagonalspring.customer.application.port.out;

import com.hedza06.hexagonalspring.customer.domain.Customer;

import java.util.List;

public interface CustomerPort
{
    Customer save(Customer customer);
    List<Customer> findByFirstNameStartingWith(String pattern);
}
