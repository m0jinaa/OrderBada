package com.farmer.OrderBada.domain.jumun.controller;

import com.farmer.OrderBada.domain.jumun.model.dto.ExcelDto;
import com.farmer.OrderBada.domain.jumun.model.dto.MailDto;
import com.farmer.OrderBada.domain.jumun.service.ExcelService;
import com.farmer.OrderBada.domain.jumun.service.JumunService;
import com.farmer.OrderBada.domain.jumun.service.MailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Tag(name = "Order API", description = "OrderBada의 주문 관련 REST API 명세를 제공")
@RequestMapping("/order")
public class JumunController {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    @Autowired
    private JumunService jumunService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private MailService mailService;

    @Value("${example.emailGetter}")
    private String emailGetter;

    @Value("${example.emailName}")
    private String emailName;

    @Value("${example.emailContent}")
    private String emailContent;

    @Operation(tags = "택배사로 메일 전송", description = "선택한 주문 목록을 엑셀로 만들어 택배사 이메일로 전송합니다.")
    @PostMapping("/email")
    public ResponseEntity<?> sendEmail(@RequestBody List<Long> idList){
        log.info("이메일로 보내고 싶은 주문 id : {}",idList);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        boolean sent;
        try {
            List<ExcelDto> list = jumunService.getOrderListForEmail(idList);

            Workbook wb = excelService.makeIntoExcel(list);

            MailDto mailDto = MailDto.builder()
                    .content(emailContent)
                    .to(emailGetter)
                    .fromName(emailName)
                    .wb(wb)
                    .build();

            sent = mailService.sendMail(mailDto);

            if (sent) {
                log.info("이메일 전송 결과 : {}", "성공");
                resultMap.put("message", SUCCESS);
                status = HttpStatus.OK;
            } else {
                log.info("이메일 전송 결과 : {}", "실패");
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("이메일 전송 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
