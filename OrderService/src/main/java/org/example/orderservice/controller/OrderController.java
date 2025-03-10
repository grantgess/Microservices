package org.example.orderservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.CreatedOrderResponse;
import org.example.orderservice.dto.OrderDTO;
import org.example.orderservice.exceptions.OrderNotCreatedException;
import org.example.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<CreatedOrderResponse> createOrder(@RequestBody @Valid OrderDTO orderDTO,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new OrderNotCreatedException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        CreatedOrderResponse response = orderService.save(orderDTO);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
