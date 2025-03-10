package org.example.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private Long orderId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name = "product_Id")
    private Long productId;

    @NotNull
    @Min(1)
    @Column(name = "quantity")
    private int quantity;

}
