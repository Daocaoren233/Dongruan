package com.homework;

import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://"+"localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "select * from emp";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+
                    "---"+rs.getInt(4)+"---"+rs.getDate(5)+"---"+rs.getInt(6)+
                    "---"+rs.getInt(7)+"---"+rs.getInt(8));
        }

        stmt.close();
        conn.close();



    }
}
