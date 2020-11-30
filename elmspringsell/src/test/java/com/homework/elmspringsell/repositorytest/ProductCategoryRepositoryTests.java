package com.homework.elmspringsell.repositorytest;

import com.homework.elmspringsell.dataobject.ProductCategory;
import com.homework.elmspringsell.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTests {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findAll(){
        List<ProductCategory> list = repository.findAll();
        for (ProductCategory e:list){
            System.out.println(e);
        }
    }

    @Test
    public void findOne(){
        System.out.println(repository.findOne(10));
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> integerList = Arrays.asList(2,3,21);
        List<ProductCategory> list = repository.findByCategoryTypeIn(integerList);
        for (ProductCategory e:list){
            System.out.println(e);
        }
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("哈皮父子");
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    @Test
    public void update(){
        ProductCategory productCategory = repository.findOne(13);
        productCategory.setUpdateTime(null);
        repository.save(productCategory);

    }

    @Test
    public void delete(){
        repository.delete(12);
    }
}
