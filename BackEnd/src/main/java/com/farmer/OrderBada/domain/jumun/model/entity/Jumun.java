package com.farmer.OrderBada.domain.jumun.model.entity;

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
public class Jumun {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long jumunId;

    @ManyToOne
    @JoinColumn(name="buyer_id")
    private User buyer;

    private String receiverName;

    private String receiverContact;

    private String receiverAddress;
    private String receiverAddressDetail;
    private String senderName;
    private String senderContact;
    private String senderAddress;
    private String senderAddressDetail;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int amount;

    private String shippingMessage;

    private String state;
    private String shippingInfo;

}
