package com.neusofy.springbootsell.repository;

import com.neusofy.springbootsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
