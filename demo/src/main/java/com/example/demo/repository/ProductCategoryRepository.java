package com.example.demo.repository;

import com.example.demo.DataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //根据CategoryType查找
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categorytypeList);

}
