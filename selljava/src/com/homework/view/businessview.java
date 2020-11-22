package com.homework.view;

import com.homework.domain.business;

public interface businessview {
//1. 查看所有商家
//2. 搜索商家
//3. 新建商家
//4. 删除商家
    public void listAllBusiness();
    public void SearchBusiness();
    public void CreateBusiness();
    public void DeleteBusiness();

    public business login();
    public void showBusiness(int businessId);
    public void updateBusiness(int businessId);
    public void updatePassword(int businessId);

}
