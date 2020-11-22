package com.homework.view.Impl;

import com.homework.dao.fooddao;
import com.homework.dao.impl.fooddaoImpl;
import com.homework.domain.food;
import com.homework.view.foodview;

import java.util.List;
import java.util.Scanner;

public class foodviewImpl implements foodview {
    fooddao fd = new fooddaoImpl();
    Scanner input = new Scanner(System.in);


    @Override
    public void showFoodList(int businessId) {
        List<food> foodList = null;
        foodList = fd.listFoodByBusinessId(businessId);
        if (foodList == null){
            System.out.println("该商店没有食品！");
        }
        else {
            for (food e: foodList){
                System.out.println(e);
            }
        }

        return;
    }

    @Override
    public void saveFood(int businessId) {
        food fo = null;
        String foodName = "";
        String foodExplain = "";
        double foodPrice = 0.0;
        System.out.print("请输入食品名称：");
        foodName = input.next();
        System.out.print("请输入食品备注：");
        foodExplain = input.next();
        System.out.print("请输入食品价格：");
        foodPrice = input.nextDouble();
        fo = new food(null,foodName,foodExplain,foodPrice,businessId);
        if (fd.saveFood(fo)==1){
            System.out.println("食品存储成功！");
        }
        else {
            System.out.println("食品存储失败！");
        }
        return;

    }

    @Override
    public void updateFood() {
        int foodId = 0;
        System.out.print("请输入需要修改的食品ID：");
        foodId = input.nextInt();
        food fo = null;
        String foodName = "";
        String foodExplain = "";
        double foodPrice = 0.0;
        System.out.print("请输入食品名称：");
        foodName = input.next();
        System.out.print("请输入食品备注：");
        foodExplain = input.next();
        System.out.print("请输入食品价格：");
        foodPrice = input.nextDouble();
        fo = new food(foodId,foodName,foodExplain,foodPrice,null);
        if (fd.updateFood(fo)==1){
            System.out.println("食品修改成功！");
        }
        else {
            System.out.println("食品修改失败！");
        }
        return;

    }

    @Override
    public void removeFood() {
        int foodId = 0;
        System.out.print("请输入你需要删除食品的ID：");
        foodId = input.nextInt();
        int result = fd.removeFood(foodId);
        if (result == 1){
            System.out.println("删除成功！");
        }
        else {
            System.out.println("删除失败！");
        }

    }
}
