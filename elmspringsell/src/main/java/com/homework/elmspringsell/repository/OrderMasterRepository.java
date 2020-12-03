package com.homework.elmspringsell.repository;

import com.homework.elmspringsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    List<OrderMaster> findByOrderStatusIn(List<Integer> orderStatusId);

    List<OrderMaster> findByPayStatusIn(List<Integer> payStatusId);


}
