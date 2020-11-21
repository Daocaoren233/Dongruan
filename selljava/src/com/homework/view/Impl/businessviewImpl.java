package com.homework.view.Impl;

import com.homework.dao.businessdao;
import com.homework.dao.impl.businessdaoImpl;
import com.homework.domain.business;
import com.homework.view.businessview;

import java.util.List;

public class businessviewImpl implements businessview {

    businessdao bd = new businessdaoImpl();

    @Override
        public void LookoverBusiness() throws Exception {

        List<business> businessList = bd.listBusiness();
        for (business e : businessList) {
            System.out.println(e);
        }
        return;
    }



}
