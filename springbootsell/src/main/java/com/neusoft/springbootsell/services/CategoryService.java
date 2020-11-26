package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.repository.ProductCategoryRepository;

import java.util.List;

public interface CategoryService {

    public ProductCategory findone(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCagetoryTypeIn(List<Integer> categoryList);

    public ProductCategory save(ProductCategory productCategory);
}
