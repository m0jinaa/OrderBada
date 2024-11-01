package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.EmailDto;

import java.sql.SQLException;
import java.util.List;
public interface JumunService {
    public List<EmailDto> getOrderListForEmail(List<Long> idList) throws SQLException;;
}
