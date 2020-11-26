package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.Productinfo;
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
    public Productinfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<Productinfo> findUpAll() {
        return repository.findAll();
    }

    @Override
    public Page<Productinfo> findAll(Pageable pageable) {
        List<Productinfo> productinfoList = repository.findAll();
//        return repository.findAll(productinfoList,pageable);
        return null;
    }

    @Override
    public Productinfo save(Productinfo productinfo) {
        return null;
    }

    @Override
    public void increaseStock(String productId) {

    }

    @Override
    public void discreaseStock(String productId) {

    }
}
