package org.example.inventoryservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
    @NotNull
    @Min(value = 0, message = "Quantity cannot be less than 0.")
    public int quantity;

    @NotNull
    @Size(min = 1, max = 50)
    public String productName;

    @NotNull
    @Min(value = 0, message = "Price cannot be less than 0")
    public Float price;
}
