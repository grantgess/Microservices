package org.example.orderservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(value = 1, message = "Quantity should be more than 0")
    private int quantity;
}
