package com.homework.elmspringsell.repository;

import com.homework.elmspringsell.dataobject.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCartRepository extends JpaRepository<ShopCart,Integer> {

}
