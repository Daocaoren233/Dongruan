package com.homework;

import com.homework.domain.business;
import com.homework.dao.impl.businessImpl;
import com.homework.view.Impl.adminviewImpl;
import com.homework.view.adminview;

import java.util.List;

public class test {

    public static void main(String[] args) throws Exception {
//        businessImpl bi = new businessImpl();
//        List<business> businessList = bi.listBusiness();
//        for (business bs: businessList)
//            System.out.println(bs);
//        int i = bi.removeBusiness(10012);
//        business bs = bi.getBusinessById(10011);
//        System.out.println(bs);

//        business bnes = new business(10011,"123456","mihayou","sss","sss",25.,4.);
//        int i = bi.updateBusiness(bnes);
//        System.out.println(i);
        adminview ad = new adminviewImpl();
        ad.login();
    }
}
