package com.homework;

import com.homework.view.Impl.adminviewImpl;
import com.homework.view.Impl.businessviewImpl;
import com.homework.view.adminview;
import com.homework.view.businessview;

import java.util.Scanner;

public class AdminEntry {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("===================================================");
        System.out.println("======================饿来么管理系统==================");
        System.out.println("===================================================");
        adminview al = new adminviewImpl();
        businessview bv = new businessviewImpl();
        if(al.login()!=null){
            System.out.println("登陆成功，欢迎来到饿来么管理系统！");
            int index = 0;
            while(index != 5){
                System.out.println("---------------------------------------------------");
                System.out.println("1. 查看所有商家\n2. 搜索商家\n3. 新建商家\n4. 删除商家\n5. 退出系统");
                System.out.print("请输入你需要操作的序号：");
                index = input.nextInt();
                switch (index){
                    case 1:
                        bv.listAllBusiness();
                        break;
                    case 2:
                        bv.SearchBusiness();
                        break;
                    case 3:
                        bv.CreateBusiness();
                        break;
                    case 4:
                        bv.DeleteBusiness();
                        break;
                    case 5:
                        System.out.println("退出成功，欢迎下次进入饿来么管理系统！");
                        System.out.println("===================================================");
                        break;
                    default:
                        System.out.println("未查询到该操作！");
                }


            }

        }
        else {
            System.out.println("登录失败，用户名密码错误！");
        }

        return;
    }
}
