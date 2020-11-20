package com.homework.view.Impl;

import com.homework.dao.admindao;
import com.homework.dao.impl.adminImpl;
import com.homework.domain.admin;
import com.homework.view.adminview;

import java.util.Scanner;

public class adminviewImpl implements adminview {
    @Override
    public admin login() {
        Scanner input = new Scanner(System.in);
//        System.out.println("===================================================");
//        System.out.println("======================饿来么管理系统==================");
//        System.out.println("===================================================");
//        System.out.println("1.登录系统");
//        System.out.println("2.退出系统");
//        int index = 0;
//        while(index != 2){
//            index = input.nextInt();
//            switch (index){
//                case 1:
//
//            }
//
//        }

        System.out.print("请输入用户名：");
        String adminName = input.next();
        System.out.print("请输入密码：");
        String password = input.next();
        admindao al = new adminImpl();

        admin ad = al.getadminBynameAndpassword(adminName,password);
        if(ad != null){
            System.out.println("登录成功！");
        }
        else {
            System.out.println("登录失败！");
        }
        return ad;
    }

}
