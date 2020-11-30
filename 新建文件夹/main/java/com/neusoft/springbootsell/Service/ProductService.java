package com.neusoft.springbootsell.Service;

import com.neusoft.springbootsell.DataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
//    查询一个商品
    ProductInfo findOne(String productId);
//    查询所有商品
    List<ProductInfo> findUPAll();
//    分页查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);
//   新增商品
    ProductInfo save(ProductInfo productInfo);
//   上架
    ProductInfo onSale(String productId);
//   下架
    ProductInfo offSale(String productId);
//    加库存
    void  increaseStock(String productId,Integer num);
//    减库存
    void  decreaseStock(String productId,Integer num);
}
