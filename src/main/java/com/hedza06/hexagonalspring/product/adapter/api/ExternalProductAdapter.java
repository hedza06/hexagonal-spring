package com.hedza06.hexagonalspring.product.adapter.api;

import com.hedza06.hexagonalspring.product.application.port.out.ExternalFakeProductPort;
import com.hedza06.hexagonalspring.product.dto.FakeProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalProductAdapter implements ExternalFakeProductPort {

    @Qualifier("restHttpsTemplate")
    private final RestTemplate restTemplate;

    @Override
    public List<FakeProductDTO> fetchAllFakeProducts()
    {
        log.info("Getting fake products from external API...");

        String url = "https://fakestoreapi.com/products";
        try
        {
            ParameterizedTypeReference<List<FakeProductDTO>> typeReference = new ParameterizedTypeReference<>(){};
            ResponseEntity<List<FakeProductDTO>> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null, typeReference
            );
            log.info("Http status code: {}", responseEntity.getStatusCodeValue());
            log.info("Sending back to client fetched fake products...");

            return responseEntity.getBody();
        }
        catch (RestClientException e)
        {
            log.error("Error occurred while fetching fake products. Error message: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
