package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.ProductDTO;
import org.example.orderservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class InventoryServiceClient {
    private final RestTemplate restTemplate;

    @Value("${inventoryHostURL}")
    private String hostURL;

    public ProductDTO getProduct(Long productId) {
        try {
            return restTemplate.getForObject(hostURL + "/products/" + productId, ProductDTO.class);
        } catch (HttpClientErrorException e) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
    }
}
