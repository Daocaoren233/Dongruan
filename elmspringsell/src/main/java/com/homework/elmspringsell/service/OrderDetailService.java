package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDetailService {
    OrderDetail findOne(String detailId);

    List<OrderDetail> findOneByOrderId(String orderId);

    List<OrderDetail> findAll();

    OrderDetail save(OrderDetail orderDetail);
}
