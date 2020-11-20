package com.homework.dao;

import com.homework.domain.admin;

public interface admindao {
    public admin getadminBynameAndpassword(String adminName,String password);
}
