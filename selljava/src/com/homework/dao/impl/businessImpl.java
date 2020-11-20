package com.homework.dao.impl;

import com.homework.dao.businessdao;
import com.homework.domain.business;
import com.homework.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class businessImpl implements businessdao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public List<business> listBusiness() throws Exception {

        List<business> businessList = new ArrayList<>();
        String sql = "select * from business";
        conn = JDBCutils.getConnection();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()){
            Integer businessId = rs.getInt(1);
            String password = rs.getString(2);
            String businessName = rs.getString(3);
            String businessAddress = rs.getString(4);
            String businessExplain = rs.getString(5);
            Double starPrice = rs.getDouble(6);
            Double deliveryPrice = rs.getDouble(7);
            business bs = new business(businessId,password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice);
            businessList.add(bs);
        }

        JDBCutils.close(rs,pst,conn);

        return businessList;
    }

    @Override
    public int saveBusiness(String businessName) throws Exception {
        int businessId = 0;

        String sql = "insert into business(businessName, password) values(?,'123')";
        conn = JDBCutils.getConnection();
        pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1,businessName);
        pst.executeUpdate();

        rs = pst.getGeneratedKeys();

        if(rs.next()){
            businessId = rs.getInt(1);
        }
        JDBCutils.close(rs,pst,conn);

        return businessId;
    }

    @Override
    public int removeBusiness(int businessId){
        int result = 0;

        String sql = "delete from business where businessId = ?" ;

        try {
            conn = JDBCutils.getConnection();
            //开启事件
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setInt(1,businessId);

            result = pst.executeUpdate();

            conn.commit();

        } catch (SQLException throwables) {
            result = 0;
            try {
                //回滚事件
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();

        }finally {
            JDBCutils.close(rs,pst,conn);
        }

        return result;
    }

    @Override
    public int updateBusiness(business bnes) {
        int result = 0;
        String sql = "update business set businessName = ?, businessAddress = ?," +
                "businessExplain = ?, starPrice = ?, deliveryPrice = ? where " +
                "businessId = ?";

        try {
            conn = JDBCutils.getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1,bnes.getBusinessName());
            pst.setString(2,bnes.getBusinessAddress());
            pst.setString(3,bnes.getBusinessExplain());
            pst.setDouble(4,bnes.getStarPrice());
            pst.setDouble(5,bnes.getDeliveryPrice());
            pst.setInt(6,bnes.getBusinessId());
            result = pst.executeUpdate();

            conn.commit();
        } catch (SQLException throwables) {
            result = 0;
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }


        return result;
    }

    @Override
    public business getBusinessById(int businessId) {
        business bs = new business();
        String sql = "select * from business where businessId = ?";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            if(rs.next()){
                business bu = new business(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDouble(6), rs.getDouble(7));
                bs = bu;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }

        return bs;
    }
}
