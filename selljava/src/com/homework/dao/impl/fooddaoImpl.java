package com.homework.dao.impl;

import com.homework.dao.fooddao;
import com.homework.domain.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class fooddaoImpl implements fooddao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    @Override
    public List<food> listFoodByBusinessId(int businessId) {
        List<food> foodList = new ArrayList<>();


        return foodList;
    }
}
