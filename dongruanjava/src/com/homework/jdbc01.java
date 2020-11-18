package com.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbc01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "update infor set balance = 3 where id = 1";

        int i = stmt.executeUpdate(sql);

        if(i == 1){
            System.out.println("更新成功！");
        }
        else{
            System.out.println("更新失败！");
        }
        stmt.close();
        conn.close();
    }
}
