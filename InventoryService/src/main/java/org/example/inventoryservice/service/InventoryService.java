package org.example.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.example.inventoryservice.dto.ProductDTO;
import org.example.inventoryservice.exceptions.ProductNotFoundException;
import org.example.inventoryservice.model.Product;
import org.example.inventoryservice.repository.InventoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(ProductDTO productDTO) {
        inventoryRepository.save(modelMapper.map(productDTO, Product.class));
    }

    public ProductDTO findById(Long id) {
        Product product = inventoryRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
        return modelMapper.map(product, ProductDTO.class);
    }
}
