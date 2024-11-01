package com.farmer.OrderBada.domain.jumun.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.sql.SQLException;

public interface EmailService {
    public boolean sendEmail(String email, Workbook workbook) throws SQLException;
}
