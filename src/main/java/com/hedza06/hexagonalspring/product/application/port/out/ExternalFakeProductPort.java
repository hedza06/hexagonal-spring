package com.hedza06.hexagonalspring.product.application.port.out;

import com.hedza06.hexagonalspring.product.dto.FakeProductDTO;

import java.util.List;

public interface ExternalFakeProductPort
{
    List<FakeProductDTO> fetchAllFakeProducts();
}
