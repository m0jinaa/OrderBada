package com.farmer.OrderBada.domain.jumun.model.dto;

import com.farmer.OrderBada.domain.jumun.model.entity.Jumun;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDto {

    String receiverName;
    String receiverPhone;
    String receiverAddress;
    String senderName;
    String senderPhone;
    String senderAddress;
    String productName;
    int productAmount;
    String shippingMessage;


    public static EmailDto toDto(Jumun jumun){
        return EmailDto.builder().receiverName(jumun.getReceiverName())
                .receiverPhone(jumun.getReceiverContact())
                .receiverAddress(jumun.getReceiverAddress()+" "+ jumun.getReceiverAddressDetail())
                .senderName(jumun.getSenderName())
                .senderPhone(jumun.getSenderContact())
                .senderAddress(jumun.getSenderAddress()+" "+ jumun.getSenderAddressDetail())
                .productName(jumun.getProduct().getName())
                .productAmount(jumun.getAmount())
                .shippingMessage(jumun.getShippingMessage())
                .build();
    }

}
