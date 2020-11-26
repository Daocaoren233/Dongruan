package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.Productinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Productinfo findOne(String productId);

    List<Productinfo> findUpAll();

    Page<Productinfo> findAll(Pageable pageable);

    Productinfo save(Productinfo productinfo);

    void increaseStock(String productId);

    void discreaseStock(String productId);


}
