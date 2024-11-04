package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.MailDto;

import java.sql.SQLException;

public interface MailService {
    boolean sendMail(MailDto mailDto) throws SQLException;
}
