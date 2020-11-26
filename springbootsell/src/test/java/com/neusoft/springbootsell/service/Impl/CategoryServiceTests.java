package com.neusoft.springbootsell.service.Impl;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.services.Impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findone(){
        System.out.println(categoryService.findone(1));
    }

    @Test
    public void findAll(){
        List<ProductCategory> list = categoryService.findAll();
        for (ProductCategory e:list){
            System.out.println(e);
        }
    }

    @Test
    public void findByCategoryType(){
        List<ProductCategory> list = categoryService.findAll();
        List<ProductCategory> listByType = categoryService.findByCagetoryTypeIn(list,2);
        for (ProductCategory e:listByType){
            System.out.println(e);
        }
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("王炸");
        productCategory.setCategoryType(2);
        categoryService.save(productCategory);
    }

}
