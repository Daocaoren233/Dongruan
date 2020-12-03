package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderMasterService {

    OrderMaster findOne(String orderId);

    Page<OrderMaster> findAll(Pageable pageable);

    List<OrderMaster> findByPayStatus(List<Integer> payStatusList);

    List<OrderMaster> findByOrderStatus(List<Integer> orderStatusList);

    OrderMaster save(OrderMaster orderMaster);

    void deleteByOrderId(String orderId);

}
