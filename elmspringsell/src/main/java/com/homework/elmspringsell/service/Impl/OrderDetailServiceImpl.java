package com.homework.elmspringsell.service.Impl;

import com.homework.elmspringsell.dataobject.OrderDetail;
import com.homework.elmspringsell.repository.OrderDetailRepository;
import com.homework.elmspringsell.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;

    @Override
    public OrderDetail findOne(String detailId) {
        return repository.findOne(detailId);
    }

    @Override
    public List<OrderDetail> findOneByOrderId(String orderId) {
        return repository.findByOrderIdIn(orderId);
    }

    @Override
    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
