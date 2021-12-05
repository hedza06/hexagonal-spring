package com.hedza06.hexagonalspring.customer.adapter.persistence;

import com.hedza06.hexagonalspring.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    List<Customer> findByFirstNameStartingWith(String pattern);
}
