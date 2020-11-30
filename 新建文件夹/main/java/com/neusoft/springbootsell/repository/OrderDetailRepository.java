package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.DataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
