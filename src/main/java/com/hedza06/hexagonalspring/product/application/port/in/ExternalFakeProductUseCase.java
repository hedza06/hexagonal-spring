package com.hedza06.hexagonalspring.product.application.port.in;

import com.hedza06.hexagonalspring.product.dto.FakeProductDTO;

import java.util.List;

public interface ExternalFakeProductUseCase
{
    List<FakeProductDTO> fetchAllFakeProducts();
}
