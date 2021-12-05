package com.hedza06.hexagonalspring.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class FakeProductDTO {

    private Integer id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;

}
