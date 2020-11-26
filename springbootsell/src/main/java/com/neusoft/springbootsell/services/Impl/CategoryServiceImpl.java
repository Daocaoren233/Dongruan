package com.neusoft.springbootsell.services.Impl;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.repository.ProductCategoryRepository;
import com.neusoft.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findone(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCagetoryTypeIn(List<ProductCategory> categoryList,Integer categoryType) {
        List<ProductCategory> list = repository.findAll();
        List<ProductCategory> listByType = new ArrayList<>();
        for (ProductCategory e:list){
            if (e.getCategoryType()==categoryType)
                listByType.add(e);
        }
        return listByType;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
