package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.ExcelDto;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.List;
public interface ExcelService {
    Workbook makeIntoExcel(List<ExcelDto> list) throws  IOException;

}
