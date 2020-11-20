package com.homework;

import com.homework.domain.emp;

import javax.xml.crypto.Data;
import java.sql.*;

public class JDBCdemo05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "select * from emp";


        ResultSet rs = stmt.executeQuery(sql);

//        while(rs.next()){
////            System.out.println("%10s",rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+
////                    "---"+rs.getInt(4)+"---"+rs.getDate(5)+"---"+rs.getInt(6)+
////                    "---"+rs.getInt(7)+"---"+rs.getInt(8));
//            System.out.printf("%-8d",rs.getInt(1));
//            System.out.printf("%-10s",rs.getString(2));
//            System.out.printf("%-10s",rs.getString(3))
//            System.out.printf("%-10s",rs.getInt(4));
//            System.out.printf("%-10s",rs.getDate(5));
//            System.out.printf("%-8d",rs.getInt(6));
//            System.out.printf("%-8d",rs.getInt(7));
//            System.out.printf("%-4d",rs.getInt(8));
//            System.out.println();
//        }

        rs.next();
        emp list = new emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
        System.out.println(list.toString());

        stmt.close();
        conn.close();
    }
}
