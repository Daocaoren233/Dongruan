package com.neusoft.springbootsell.Service;

import com.neusoft.springbootsell.DataObject.ProductCategory;

import java.util.List;

public interface CateoryService {
    //根据categoryid查询ProductCategory产品分类信息
    public ProductCategory findOne(Integer categoryId);
    //查询所有产品分类目录
    public List<ProductCategory> findAll();
    //通过产品编号列表查询相应的产品分类信息
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    //保存一个产品分类信息
    public ProductCategory save(ProductCategory productCategory);
}
