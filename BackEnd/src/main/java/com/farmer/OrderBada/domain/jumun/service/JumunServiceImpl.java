package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.ExcelDto;
import com.farmer.OrderBada.domain.jumun.model.entity.Jumun;
import com.farmer.OrderBada.domain.jumun.model.repository.JumunRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JumunServiceImpl implements JumunService {
    @Autowired
    JumunRepository jumunRepository;
    @Override
    public List<ExcelDto> getOrderListForEmail(List<Long> idList) {

        List<Jumun> list = jumunRepository.findByJumunIdIsIn(idList);

        List<ExcelDto> ret = list.stream().map(o -> ExcelDto.toDto(o)).collect(Collectors.toList());

        log.info("조회한 주문 정보:{}",ret);
        return ret;
    }
}
