package com.homework.elmspringsell.service.Impl;

import com.homework.elmspringsell.dataobject.SellerInfo;
import com.homework.elmspringsell.repository.SellerInfoRepository;
import com.homework.elmspringsell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findOne(String Id) {
        return repository.findOne(Id);
    }

    @Override
    public String findPassWordById(String Id) {
        return repository.findOne(Id).getPassword();

    }

    @Override
    public String findSellerNameById(String Id) {
        return repository.findOne(Id).getUsername();
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        return repository.save(sellerInfo);
    }

    @Override
    public List<SellerInfo> findAll() {
        return repository.findAll();
    }
}
