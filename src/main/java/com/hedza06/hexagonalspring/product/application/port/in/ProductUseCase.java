package com.hedza06.hexagonalspring.product.application.port.in;

import com.hedza06.hexagonalspring.product.domain.Product;

import java.util.Optional;

public interface ProductUseCase
{
    Product save(Product product);
    Optional<Product> findById(Integer id);
}
