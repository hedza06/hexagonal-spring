package com.hedza06.hexagonalspring.customer.application.port.in;

import com.hedza06.hexagonalspring.customer.domain.Customer;

import java.util.List;

public interface CustomerUseCase
{
    Customer save(Customer customer);
    List<Customer> findByFirstNameStartingWith(String pattern);
}
