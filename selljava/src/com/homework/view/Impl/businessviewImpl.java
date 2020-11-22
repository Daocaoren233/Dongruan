package com.homework.view.Impl;

import com.homework.dao.businessdao;
import com.homework.dao.impl.businessdaoImpl;
import com.homework.domain.business;
import com.homework.view.businessview;

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
            if(list != null){
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

    @Override
    public business login() {
        business bs = null;
        System.out.print("请输入用户名ID：");
        int businessId = input.nextInt();
        System.out.print("请输入密码：");
        String password = input.next();
        bs = bd.getBisinessByIdandPassword(businessId,password);
        if (bs != null){
            System.out.println("商家"+bs.getBusinessName()+"欢迎回来！");
        }
        else {
            System.out.println("用户名密码错误！");
        }

        return bs;
    }

    @Override
    public void showBusiness(int businessId) {
        business bs = bd.getBusinessById(businessId);
        if (bs != null){
            System.out.println(bs);
        }
        else {
            System.out.println("此用户账号已经注销，请重新申请账号！");
        }
        return;
    }


    @Override
    public void updateBusiness(int businessId) {
        String businessName = "";
        String businessAddress = "";
        String businessExplain = "";
        double starPrice = 0.0;
        double deliveryPrice = 0.0;
        System.out.print("请输入新的店名：");
        businessName = input.next();
        System.out.print("请输入新的地址：");
        businessAddress = input.next();
        System.out.print("请输入新的备注：");
        businessExplain = input.next();
        System.out.print("请输入新的启送费：");
        starPrice = input.nextDouble();
        System.out.print("请输入新的运送费：");
        deliveryPrice = input.nextDouble();

        business bs = new business(businessId,null,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);
        int i = bd.updateBusiness(bs);
        if (i == 1){
            System.out.println("修改成功！");
        }
        else{
            System.out.println("修改失败！");
        }
        return;

    }

    @Override
    public void updatePassword(int businessId) {
        System.out.print("请输入旧密码：");
        String oldpass = input.next();
        String newpass = "";
        String renewpass = "";
        String password = bd.getBusinessById(businessId).getPassword();
        if (password.equals(oldpass)){
            boolean flag = true;
            while(flag){
                System.out.print("请输入新密码：");
                newpass = input.next();
                System.out.print("请再次输入新密码：");
                renewpass = input.next();
                if (newpass.equals(renewpass)){
                    flag = false;
                }
                else {
                    System.out.println("密码不一致！");
                }
            }
            int i = bd.updateBusinessPassword(businessId,newpass);
            if (i == 1){
                System.out.println("修改成功！");
            }
            else {
                System.out.println("修改失败！");
            }

        }
        else {
            System.out.println("密码错误！");
        }



    }


}
