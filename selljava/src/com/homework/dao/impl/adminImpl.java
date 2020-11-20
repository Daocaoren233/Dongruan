package com.homework.dao.impl;

import com.homework.dao.admindao;
import com.homework.domain.admin;
import com.homework.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminImpl implements admindao {
    Connection conn = null;
    PreparedStatement pmt = null;
    ResultSet rs = null;
    @Override
    public admin getadminBynameAndpassword(String adminName, String password) {
        admin am = null;
        String sql = "select * from admin where adminName = ? and password = ?";
        try {
            conn = JDBCutils.getConnection();
            pmt = conn.prepareStatement(sql);
            pmt.setString(1,adminName);
            pmt.setString(2,password);
            rs = pmt.executeQuery();
            if (rs.next()){
                am = new admin(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCutils.close(rs,pmt,conn);
        }

        return am;
    }
}
