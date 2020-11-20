package com.homework;

import com.homework.domain.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.homework.utils.JDBCutils.*;

public class JDBCdome06 {
    public static void main(String[] args) throws Exception {
//        List<emp> empList = Allfind();
        List<emp> empList = Allfind2();
        for (emp e : empList){
            System.out.println(e);
        }


    }

    public static List<emp> Allfind() throws ClassNotFoundException, SQLException {
        List<emp> empList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "select * from emp";

        ResultSet rs = stmt.executeQuery(sql);


        while(rs.next()){
            emp list = new emp(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getInt(4),rs.getDate(5),rs.getInt(6),
                    rs.getInt(7),rs.getInt(8));
            empList.add(list);
        }

        rs.close();
        stmt.close();
        conn.close();

        return empList;

    }

    public static List<emp> Allfind2() throws Exception {
        List<emp> empList = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        String sql = "select * from emp";

        ResultSet rs = stmt.executeQuery(sql);


        while(rs.next()){
            emp list = new emp(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getInt(4),rs.getDate(5),rs.getInt(6),
                    rs.getInt(7),rs.getInt(8));
            empList.add(list);
        }

        close(rs,stmt,conn);

        return empList;
    }
}
