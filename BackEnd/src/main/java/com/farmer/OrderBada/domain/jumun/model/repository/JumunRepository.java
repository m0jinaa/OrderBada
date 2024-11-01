package com.farmer.OrderBada.domain.jumun.model.repository;

import com.farmer.OrderBada.domain.jumun.model.entity.Jumun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JumunRepository extends JpaRepository<Jumun,Long> {
    List<Jumun> findByJumunIdIsIn(List<Long> idList);
}
