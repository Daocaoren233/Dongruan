package com.homework;

import com.homework.domain.business;
import com.homework.view.Impl.businessviewImpl;
import com.homework.view.Impl.foodviewImpl;
import com.homework.view.businessview;
import com.homework.view.foodview;

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
                    //TODO
                    case 1:
                        bv.showBusiness(bs.getBusinessId());
                        break;
                    //TODO
                    case 2:
                        bv.updateBusiness(bs.getBusinessId());
                        break;
                    //TODO
                    case 3:
                        bv.updatePassword(bs.getBusinessId());
                        break;
                    //TODO
                    case 4:
                        runfood(bs.getBusinessId());
                        break;
                    //TODO
                    case 5:
                        System.out.println("退出成功，欢迎下次进入饿来么管理系统！");
                        System.out.println("===================================================");
                        break;
                    //TODO
                    default:
                        System.out.println("未查询到该操作！");
                }


            }

        }


        return;
    }

    public static void runfood(int businessId){
        Scanner input = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("==================饿来么食品管理系统===============");
        System.out.println("===============================================");
        foodview fv = new foodviewImpl();
        int index = 0;
        while(index != 5){
            System.out.println("----------------------------------------------");
            System.out.println("1.     查看食品信息\n2.     修改食品信息\n3.     增加食品信息\n4.     删除食品信息\n5.     返回上一级");
            System.out.print("请输入你需要操作的序号：");
            index = input.nextInt();
            switch (index){
                //TODO
                case 1:
                    fv.showFoodList(businessId);
                    break;
                //TODO
                case 2:
                    fv.updateFood();
                    break;
                //TODO
                case 3:
                    fv.saveFood(businessId);
                    break;
                //TODO
                case 4:
                    fv.removeFood();
                    break;
                //TODO
                case 5:
                    System.out.println("返回上一级成功");
                    System.out.println("===============================================");
                    break;
                //TODO
                default:
                    System.out.println("未查询到该操作！");
            }
        }



        return;

    }

}
