package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.ShopCart;

import java.util.List;

public interface ShopCartService {
    List<ShopCart> findAll();

    ShopCart save(ShopCart shopCart);

    void deleteAll();
}
