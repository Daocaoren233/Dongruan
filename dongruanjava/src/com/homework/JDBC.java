package com.homework;

import java.sql.*;


public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "update infor set balance = 3 where id = 1";
        String sql1 = "select id,name,balance from infor";
        String sql2 = "insert into infor values(2,'jack',6780)";
        String sql3 = "delete from infor where id = 1";


//        ResultSet rs = stmt.executeQuery(sql1);
//
//        while(rs.next()){
//            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
//        }


        int i = stmt.executeUpdate(sql3);

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
