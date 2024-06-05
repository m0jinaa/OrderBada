package com.farmer.OrderBada.domain.order.model.entity;

import com.farmer.OrderBada.domain.contact.model.entity.Contact;
import com.farmer.OrderBada.domain.product.model.entity.Product;
import com.farmer.OrderBada.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private User buyer;

    private String getterName;

    private String getterContact;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Contact senderInfo;

    @ManyToOne
    @JoinColumn(name="getter_id")
    private Contact getterInfo;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int count;

    private String shippingMessage;

    private String state;

    private String shippingInfo;

}
