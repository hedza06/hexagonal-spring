package com.hedza06.hexagonalspring.customer.adapter.web;

import com.hedza06.hexagonalspring.customer.application.port.in.CustomerUseCase;
import com.hedza06.hexagonalspring.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
class CustomerController {

    private final CustomerUseCase customerUseCase;

    @PostMapping
    public ResponseEntity<Customer> persist(@RequestBody Customer customer)
    {
        Customer persistedCustomer = customerUseCase.save(customer);
        return new ResponseEntity<>(persistedCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/by-first-name-starting-with")
    public ResponseEntity<List<Customer>> findByNameStartingWith(@RequestParam(value = "pattern") String pattern)
    {
        List<Customer> customers = customerUseCase.findByFirstNameStartingWith(pattern);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
