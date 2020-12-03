package com.homework.elmspringsell.repository;

import com.homework.elmspringsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatusIn(Integer productStatus);

}
