package com.homework.view.Impl;

import com.homework.dao.admindao;
import com.homework.dao.impl.admindaoImpl;
import com.homework.domain.admin;
import com.homework.view.adminview;

import java.util.Scanner;

public class adminviewImpl implements adminview {
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

}
