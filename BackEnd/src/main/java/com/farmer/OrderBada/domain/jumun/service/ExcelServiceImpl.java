package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.ExcelDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService{

    @Override
    public Workbook makeIntoExcel(List<ExcelDto> list) {
        Workbook wb = new XSSFWorkbook();

        //오늘 날짜로 sheet 하나 만들기
        Sheet sheet = wb.createSheet(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        int rowNo = 0;
        Row headerRow = sheet.createRow(rowNo++);

        headerRow.createCell(0).setCellValue("받는분성명");
        headerRow.createCell(1).setCellValue("받는분전화번호");
        headerRow.createCell(2).setCellValue("받는분기타연락처");
        headerRow.createCell(3).setCellValue("받는분주소(전체, 분할)");
        headerRow.createCell(4).setCellValue("보내는분성명");
        headerRow.createCell(5).setCellValue("보내는분전화번호");
        headerRow.createCell(6).setCellValue("보내는분기타연락처");
        headerRow.createCell(7).setCellValue("보내는분주소(전체, 분할)");
        headerRow.createCell(8).setCellValue("품목명");
        headerRow.createCell(9).setCellValue("박스수량");
        headerRow.createCell(10).setCellValue("배송메세지1");

        for(ExcelDto email : list){
            Row row = sheet.createRow(rowNo++);

            row.createCell(0).setCellValue(email.getReceiverName());
            row.createCell(1).setCellValue(email.getReceiverPhone());
            row.createCell(3).setCellValue(email.getReceiverAddress());
            row.createCell(4).setCellValue(email.getSenderName());
            row.createCell(5).setCellValue(email.getSenderPhone());
            row.createCell(7).setCellValue(email.getSenderAddress());
            row.createCell(8).setCellValue(email.getProductName());
            row.createCell(9).setCellValue(email.getProductAmount());
            row.createCell(10).setCellValue(email.getShippingMessage());
        }

        return wb;
    }
}
