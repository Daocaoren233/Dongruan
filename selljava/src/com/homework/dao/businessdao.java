package com.homework.dao;

import com.homework.domain.business;

import java.sql.SQLException;
import java.util.List;

public interface businessdao {
    public List<business> listBusiness(String businessName, String businessAddress) throws Exception;

    public int saveBusiness(String businessName) throws SQLException, Exception;

    public int removeBusiness(int businessId) throws SQLException;

    public int updateBusiness(business bnes);

    public business getBusinessById(int businessId);

    public business getBisinessByIdandPassword(int businessId,String password);

    public int updateBusinessPassword(int businessId,String password);

}
