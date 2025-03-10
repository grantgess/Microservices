package org.example.inventoryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "inventory_table")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public long productId;

    @Column(name = "product_name")
    @NotNull
    @Size(min = 1, max = 50)
    public String productName;

    @NotNull
    @Min(value = 0, message = "Quantity cannot be less than 0.")
    @Column(name = "quantity")
    public int quantity;

    @NotNull
    @Min(value = 0, message = "Price cannot be less than 0")
    @Column(name = "price")
    public Float price;
}
