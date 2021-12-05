package com.hedza06.hexagonalspring.product.application.port.out;

import com.hedza06.hexagonalspring.product.domain.Product;

import java.util.Optional;

public interface ProductPort
{
    Product save(Product product);
    Optional<Product> findById(Integer id);
}
