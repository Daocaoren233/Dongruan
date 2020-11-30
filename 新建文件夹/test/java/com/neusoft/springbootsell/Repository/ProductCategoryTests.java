package com.neusoft.springbootsell.Repository;


import com.neusoft.springbootsell.DataObject.ProductCategory;
import com.neusoft.springbootsell.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTests {
    @Autowired
    ProductCategoryRepository repository;
    private final String openId = "1212321";

    @Test
    public void saveProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("零食");
        productCategory.setCategoryType("213");

        ProductCategory result = repository.save(productCategory);
//        return result;
        Assert.assertNotNull(result);//判断是否为空
    }
}
