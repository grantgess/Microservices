package org.example.orderservice.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreatedOrderResponse {
    private String productName;
    private int quantity;
    private Float pricePerPiece;
    private Float totalPrice;

}
