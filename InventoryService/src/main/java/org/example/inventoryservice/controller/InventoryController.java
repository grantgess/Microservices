package org.example.inventoryservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.inventoryservice.dto.ProductDTO;
import org.example.inventoryservice.exceptions.ProductNotCreatedException;
import org.example.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO productDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ProductNotCreatedException("Product not created: " + bindingResult.getAllErrors());
        }
        inventoryService.save(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable long id) {
        ProductDTO productDTO = inventoryService.findById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
