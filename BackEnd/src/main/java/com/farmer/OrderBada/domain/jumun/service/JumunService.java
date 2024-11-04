package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.ExcelDto;

import java.sql.SQLException;
import java.util.List;
public interface JumunService {
    List<ExcelDto> getOrderListForEmail(List<Long> idList) throws SQLException;
}
