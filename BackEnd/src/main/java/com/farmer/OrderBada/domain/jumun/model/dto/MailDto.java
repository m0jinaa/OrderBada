package com.farmer.OrderBada.domain.jumun.model.dto;

import lombok.*;
import org.apache.poi.ss.usermodel.Workbook;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailDto{
    String to;
    String fromName;
    String content;
    Workbook wb;
}
