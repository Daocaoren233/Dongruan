package com.homework.elmspringsell.service;

import com.homework.elmspringsell.dataobject.SellerInfo;

public interface SellerInfoService {
    public SellerInfo findOne(String Id);

    public String findPassWordById(String Id);

    public String findSellerNameById(String Id);

    public SellerInfo save(SellerInfo sellerInfo);
}
