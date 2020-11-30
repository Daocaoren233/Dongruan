package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);

    void increaseStock(String productId);

    void decreaseStock(String productId);


}
