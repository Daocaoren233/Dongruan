package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.enums.ProductStatus;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.repository.ProductinfoRepository;
import com.neusoft.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductinfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        List<ProductInfo> productinfoList = repository.findAll();
//        return repository.findAll(productinfoList,pageable);
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productinfo) {
        return null;
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productinfo = repository.findOne(productId);
        if (productinfo == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (productinfo.getProduct_status() == ProductStatus.UP.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        productinfo.setProduct_status(ProductStatus.UP.getCode());
        return repository.save(productinfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productinfo = repository.findOne(productId);
        if (productinfo == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (productinfo.getProduct_status() == ProductStatus.DOWN.getCode()){
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        productinfo.setProduct_status(ProductStatus.DOWN.getCode());
        return repository.save(productinfo);
    }


    @Override
    public void increaseStock(String productId) {

    }

    @Override
    public void discreaseStock(String productId) {

    }
}
