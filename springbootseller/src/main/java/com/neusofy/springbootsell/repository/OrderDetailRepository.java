package com.neusofy.springbootsell.repository;

import com.neusofy.springbootsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
