package com.homework.view.Impl;

import com.homework.dao.businessdao;
import com.homework.dao.impl.businessdaoImpl;
import com.homework.domain.business;
import com.homework.view.businessview;
import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class businessviewImpl implements businessview {
    businessdao bd = new businessdaoImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public void listAllBusiness() {
        try {
            List<business> businessList = bd.listBusiness(null,null);
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
        String flag = "";
        String businessName = "";
        String businessAddress = "";
        System.out.print("请输入是否输入商家名称（y/n）: ");
        flag = input.next();
        if (flag.equals("y")){
            System.out.print("请输入商家名称: ");
            businessName = input.next();
        }

        System.out.print("请输入是否输入商家地址（y/n）: ");
        flag = input.next();
        if (flag.equals("y")){
            System.out.print("请输入商家地址: ");
            businessAddress = input.next();
        }

        try {
            List<business> list = bd.listBusiness(businessName,businessAddress);
            if(list[0] != null){
                for (business e : list){
                    System.out.println(e);
                }
            }
            else {
                System.out.println("不存在该商家！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return;

    }

    @Override
    public void CreateBusiness() {
        System.out.print("请输入新建的商店名：");
        String businessName = input.next();
        try {
            int businessId = bd.saveBusiness(businessName);
            if (businessId > 0){
                System.out.println("新建成功，商店的ID为 "+businessId);
            }
            else {
                System.out.println("新建失败！");
            }
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
