package com.farmer.OrderBada.domain.store.model.entity;

import com.farmer.OrderBada.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long storeId;

    private String name;

    @OneToOne(mappedBy = "owner_id")
    private User owner;
}
