package com.homework;

import com.homework.utils.JDBCutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdemo07 {
    public static void IsRight(String username,int password) throws Exception {
        Connection conn = JDBCutils.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from passkey where username ='"+username+"'and password ="+password;
        ResultSet rs = stmt.executeQuery(sql);
//        System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3));
        if(rs.next()){
            System.out.println("登录成功！");
        }
        else{
            System.out.println("登录失败！");
        }
        JDBCutils.close(rs,stmt,conn);
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入用户名：");
        String username = sc.nextLine();
        System.out.print("输入密码：");
        int password = sc.nextInt();
        IsRight(username,password);
    }
}
