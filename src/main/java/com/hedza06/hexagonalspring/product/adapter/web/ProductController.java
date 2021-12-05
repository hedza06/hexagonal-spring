package com.hedza06.hexagonalspring.product.adapter.web;

import com.hedza06.hexagonalspring.product.application.port.in.ExternalFakeProductUseCase;
import com.hedza06.hexagonalspring.product.application.port.in.ProductUseCase;
import com.hedza06.hexagonalspring.product.domain.Product;
import com.hedza06.hexagonalspring.product.dto.FakeProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ExternalFakeProductUseCase fakeProductUseCase;

    @PostMapping
    public ResponseEntity<Product> persist(@RequestBody Product product)
    {
        Product persistedProduct = productUseCase.save(product);
        return new ResponseEntity<>(persistedProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Integer id)
    {
        Optional<Product> optionalProduct = productUseCase.findById(id);
        return optionalProduct
            .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/fake")
    public ResponseEntity<List<FakeProductDTO>> getFakeProducts()
    {
        List<FakeProductDTO> fakeProducts = fakeProductUseCase.fetchAllFakeProducts();
        return new ResponseEntity<>(fakeProducts, HttpStatus.OK);
    }
}
