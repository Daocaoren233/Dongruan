package com.homework.view.Impl;

import com.homework.dao.admindao;
import com.homework.dao.businessdao;
import com.homework.dao.impl.admindaoImpl;
import com.homework.dao.impl.businessdaoImpl;
import com.homework.domain.admin;
import com.homework.domain.business;
import com.homework.view.adminview;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class adminviewImpl implements adminview {
    businessdao bd = new businessdaoImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public admin login() {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String adminName = input.next();
        System.out.print("请输入密码：");
        String password = input.next();
        admindao al = new admindaoImpl();

        admin ad = al.getadminBynameAndpassword(adminName,password);

        return ad;
    }

    @Override
    public void LookoverBusiness() {
        try {
            List<business> businessList = bd.listBusiness();
            for (business e : businessList){
                System.out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;

    }

    @Override
    public void SearchBusiness() {
        System.out.println("请输入你要查找商家的ID");
        int businessId = input.nextInt();
        business bs = bd.getBusinessById(businessId);
        if (bs!=null){
            System.out.println(bs);
        }
        else {
            System.out.println("不存在该商家！");
        }
        return;

    }

    @Override
    public void CreateBusiness() {
        System.out.print("请输入新建的商店名：");
        String businessName = input.next();
        try {
            int businessId = bd.saveBusiness(businessName);
            System.out.println("新建成功，商店的ID为 "+businessId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;

    }

    @Override
    public void DeleteBusiness() {
        System.out.print("请输入需要删除的商店ID：");
        int businessId = input.nextInt();
        int result = 0;
        try {
            result = bd.removeBusiness(businessId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (result == 1){
            System.out.println("商家删除成功！");
        }
        else {
            System.out.println("不存在该商家！");
        }

        return;

    }

}
