package com.homework.elmspringsell.service.Impl;

import com.homework.elmspringsell.dataobject.ShopCart;
import com.homework.elmspringsell.repository.ShopCartRepository;
import com.homework.elmspringsell.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartRepository repository;

    @Override
    public List<ShopCart> findAll() {
        return repository.findAll();
    }

    @Override
    public ShopCart save(ShopCart shopCart) {
        return repository.save(shopCart);
    }

    @Override
    public void deleteAll() {
        List<ShopCart> shopCartList = repository.findAll();
        for (ShopCart shopCart:shopCartList){
            repository.delete(shopCart.getId());
        }
        return;
    }
}
