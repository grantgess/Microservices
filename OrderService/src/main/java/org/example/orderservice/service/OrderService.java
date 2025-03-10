package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.dto.CreatedOrderResponse;
import org.example.orderservice.dto.OrderDTO;
import org.example.orderservice.dto.ProductDTO;
import org.example.orderservice.dto.UserDTO;
import org.example.orderservice.exceptions.OrderNotCreatedException;
import org.example.orderservice.model.Order;
import org.example.orderservice.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserServiceClient userServiceClient;
    private final InventoryServiceClient inventoryServiceClient;
    private final ModelMapper modelMapper;

    public CreatedOrderResponse save(OrderDTO orderDTO) {
        UserDTO userDTO = userServiceClient.getUser(orderDTO.getUserId());
        ProductDTO productDTO = inventoryServiceClient.getProduct(orderDTO.getProductId());

        if (orderDTO.getQuantity() <= productDTO.getQuantity()) {
            orderRepository.save(modelMapper.map(orderDTO, Order.class));
            return CreatedOrderResponse.builder()
                    .productName(productDTO.getProductName())
                    .pricePerPiece(productDTO.getPrice())
                    .quantity(orderDTO.getQuantity())
                    .totalPrice(productDTO.getPrice() * orderDTO.getQuantity())
                    .build();

        } else {
            throw new OrderNotCreatedException("Order not created. The maximum quantity is " + productDTO.getQuantity());
        }
    }
}
