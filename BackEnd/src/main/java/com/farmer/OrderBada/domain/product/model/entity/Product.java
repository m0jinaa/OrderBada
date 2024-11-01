package com.farmer.OrderBada.domain.product.model.entity;

import com.farmer.OrderBada.domain.store.model.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long productId;

    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    private String name;

    private String imageUrl;

    private String description;

    private int price;

}
