package com.farmer.OrderBada.domain.jumun.model.dto;

import com.farmer.OrderBada.domain.jumun.model.entity.Jumun;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcelDto {

    String receiverName;
    String receiverPhone;
    String receiverAddress;
    String senderName;
    String senderPhone;
    String senderAddress;
    String productName;
    int productAmount;
    String shippingMessage;


    public static ExcelDto toDto(Jumun jumun){
        return ExcelDto.builder().receiverName(jumun.getReceiverName())
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
