package com.homework.elmspringsell.serviceimpltest;

import com.homework.elmspringsell.dataobject.ProductCategory;
import com.homework.elmspringsell.service.Impl.ProductCategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTests {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne(){
        ProductCategory productCategory = productCategoryService.findOne(3);
        Assert.assertEquals(Integer.valueOf(3),productCategory.getCategoryId());
    }

    @Test
    public void findAll(){
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());

    }

    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(2,3,21));
        Assert.assertEquals(3,productCategoryList.size());

    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("抖音潮流");
        productCategory.setCategoryType(4);
        ProductCategory res = productCategoryService.save(productCategory);
        Assert.assertNotNull(res);

    }


}
