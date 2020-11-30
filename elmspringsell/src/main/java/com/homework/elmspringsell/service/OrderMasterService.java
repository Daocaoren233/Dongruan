package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.OrderMaster;

import java.util.List;

public interface OrderMasterService {

    OrderMaster findOne(String orderId);

    List<OrderMaster> findAll();

    List<OrderMaster> findByPayStatus(List<Integer> payStatusList);

    List<OrderMaster> findByOrderStatus(List<Integer> orderStatusList);

    OrderMaster save(OrderMaster orderMaster);

    void deleteByOrderId(String orderId);

}
