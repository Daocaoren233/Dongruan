package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    public ProductCategory findone(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCagetoryTypeIn(List<ProductCategory> categoryList,Integer categoryType);

    public ProductCategory save(ProductCategory productCategory);
}
