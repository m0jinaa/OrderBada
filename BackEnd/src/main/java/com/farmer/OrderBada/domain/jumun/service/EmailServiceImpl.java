package com.farmer.OrderBada.domain.jumun.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmailServiceImpl implements EmailService{
    @Override
    public boolean sendEmail(String email, Workbook workbook) throws SQLException {
        return false;
    }
}
