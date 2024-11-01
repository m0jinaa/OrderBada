package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.EmailDto;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public interface ExcelService {
    public Workbook makeIntoExcel(List<EmailDto> list) throws SQLException, IOException;

}
