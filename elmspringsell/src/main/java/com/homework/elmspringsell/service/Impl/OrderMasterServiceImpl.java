package com.homework.elmspringsell.service.Impl;

import com.homework.elmspringsell.dataobject.OrderMaster;
import com.homework.elmspringsell.repository.OrderMasterRepository;
import com.homework.elmspringsell.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterRepository repository;

    @Override
    public OrderMaster findOne(String orderId) {
        return repository.findOne(orderId);
    }

    @Override
    public Page<OrderMaster> findAll(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = repository.findAll(pageable);
        return orderMasterPage;
    }


    @Override
    public List<OrderMaster> findByPayStatus(List<Integer> payStatusList) {
        return repository.findByPayStatusIn(payStatusList);
    }

    @Override
    public List<OrderMaster> findByOrderStatus(List<Integer> orderStatusList) {
        return repository.findByOrderStatusIn(orderStatusList);
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return repository.save(orderMaster);
    }

    @Override
    public void deleteByOrderId(String orderId) {
        repository.delete(orderId);
    }
}
