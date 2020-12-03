package com.homework.elmspringsell.repository;

import com.homework.elmspringsell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
}
