package com.homework;

import com.homework.domain.business;
import com.homework.view.Impl.adminviewImpl;
import com.homework.view.Impl.businessviewImpl;
import com.homework.view.adminview;
import com.homework.view.businessview;

import java.util.Scanner;

public class ElmBusinessAdminEntry {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("===================================================");
        System.out.println("=====================饿来么商家系统===================");
        System.out.println("===================================================");
        businessview bv = new businessviewImpl();
        business bs = bv.login();
        if(bs != null){
            int index = 0;
            while(index != 5){
                System.out.println("---------------------------------------------------");
                System.out.println("1. 查看商家信息\n2. 修改商家信息\n3. 修改密码\n4. 所属商品管理\n5. 退出系统");
                System.out.print("请输入你需要操作的序号：");
                index = input.nextInt();
                switch (index){
                    case 1:
                        bv.showBusiness(bs.getBusinessId());
                        break;
                    case 2:
                        bv.updateBusiness(bs.getBusinessId());
                        break;
                    case 3:
                        bv.updatePassword(bs.getBusinessId());
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


        return;
    }
}
