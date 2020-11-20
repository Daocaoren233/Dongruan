package com.homework.dao;

import com.homework.domain.business;

import java.sql.SQLException;
import java.util.List;

public interface businessdao {
    public List<business> listBusiness() throws Exception;

    public int saveBusiness(String businessName) throws SQLException, Exception;

    public int removeBusiness(int businessId) throws SQLException;

    public int updateBusiness(business bnes);

    public business getBusinessById(int businessId);

}
