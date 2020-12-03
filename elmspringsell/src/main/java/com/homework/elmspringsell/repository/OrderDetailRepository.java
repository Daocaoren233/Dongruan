package com.homework.elmspringsell.repository;

import com.homework.elmspringsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    public List<OrderDetail> findByOrderIdIn(String orderId);
}
