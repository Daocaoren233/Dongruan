package com.neusoft.springbootsell.Service.Impl;

import com.neusoft.springbootsell.DataObject.ProductInfo;
import com.neusoft.springbootsell.Service.ProductService;
import com.neusoft.springbootsell.enums.ProductStatusEnum;
import com.neusoft.springbootsell.enums.ResultEnum;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
//        return null;
    }

    @Override
    public List<ProductInfo> findUPAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
//        (pageable.getPageNumber()-1,pageable.getPageSize());
//        PageRequest pageRequest = new PageRequest(pageable.getPageNumber()-1,pageable.getPageSize());
        return  repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo ;
        productInfo = repository.findOne(productId);
        if(productInfo.getProductStatus() == ResultEnum.PRODUCT_NOT_EXIST.getCode()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//            throw
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
//            throw
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return  repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo ;
        productInfo = repository.findOne(productId);
        if(productInfo.getProductStatus() == ResultEnum.PRODUCT_NOT_EXIST.getCode()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//            throw
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
//            throw
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return  repository.save(productInfo);

    }

    @Override
    public void increaseStock(String productId,Integer num) {
        //todo
        ProductInfo productInfo= repository.findOne(productId);
        if(productInfo.getProductStatus() == ResultEnum.PRODUCT_NOT_EXIST.getCode()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//            throw
        }
        productInfo.setProductStock(productInfo.getProductStatus()+num);
        repository.save(productInfo);
        return;
    }

    @Override
    public void decreaseStock(String productId,Integer num) {
        //todo
        ProductInfo productInfo= repository.findOne(productId);
        if(productInfo.getProductStatus() == ResultEnum.PRODUCT_NOT_EXIST.getCode()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
//            throw
        }
        if (productInfo.getProductStock() < num){
            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
//            throw
        }
        productInfo.setProductStock(productInfo.getProductStatus()+num);
        repository.save(productInfo);
        return;
    }
}
