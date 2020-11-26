package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productinfo);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);

    void increaseStock(String productId);

    void discreaseStock(String productId);


}
