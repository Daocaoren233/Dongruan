package com.homework.dao.impl;

import com.homework.dao.fooddao;
import com.homework.domain.food;
import com.homework.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fooddaoImpl implements fooddao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    @Override
    public List<food> listFoodByBusinessId(int businessId) {
        List<food> foodList = new ArrayList<>();
        String sql = "select * from food where businessId = ?";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            while(rs.next()){
                int foodId = rs.getInt(1);
                String foodName = rs.getString(2);
                String foodExplain = rs.getString(3);
                double foodPrice = rs.getDouble(4);
                food fo = new food(foodId,foodName,foodExplain,foodPrice,businessId);
                foodList.add(fo);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }
        return foodList;
    }

    @Override
    public int saveFood(food fo) {
        int result = 0;
        String sql = "insert into food(foodName,foodExplain,foodPrice,businessId) values(?,?,?,?)";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,fo.getFoodName());
            pst.setString(2,fo.getFoodExplain());
            pst.setDouble(3,fo.getFoodPrice());
            pst.setInt(4,fo.getBusinessId());
            result = pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }

        return result;
    }

    @Override
    public int updateFood(food fo) {
        int result = 0;
        String sql = "update food set foodName = ?,foodExplain = ?, foodPrize = ? where foodId = ?";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,fo.getFoodName());
            pst.setString(2,fo.getFoodExplain());
            pst.setDouble(3,fo.getFoodPrice());
            pst.setInt(4,fo.getFoodId());
            result = pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }

        return result;
    }

    @Override
    public int removeFood(int foodId) {
        int result = 0;
        String sql = "delete from food where foodId = ?";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,foodId);
            result = pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }
        return result;
    }

    @Override
    public food getFoodByfoodId(int foodId) {
        food fo = null;
        String sql = "select * from food where foodId = ?";
        try {
            conn = JDBCutils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,foodId);
            rs = pst.executeQuery();
            fo = new food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCutils.close(rs,pst,conn);
        }

        return fo;
    }
}
