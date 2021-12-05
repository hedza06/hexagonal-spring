package com.hedza06.hexagonalspring.customer.application.service;

import com.hedza06.hexagonalspring.customer.application.port.in.CustomerUseCase;
import com.hedza06.hexagonalspring.customer.application.port.out.CustomerPort;
import com.hedza06.hexagonalspring.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {

    private final CustomerPort customerPort;

    @Override
    public Customer save(Customer customer) {
        return customerPort.save(customer);
    }

    @Override
    public List<Customer> findByFirstNameStartingWith(String pattern) {
        return customerPort.findByFirstNameStartingWith(pattern);
    }
}
