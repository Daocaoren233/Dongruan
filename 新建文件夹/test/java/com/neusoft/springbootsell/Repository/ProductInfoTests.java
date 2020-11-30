package com.neusoft.springbootsell.Repository;


import com.neusoft.springbootsell.DataObject.ProductInfo;
import com.neusoft.springbootsell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoTests {
    @Autowired
    ProductInfoRepository repository;
    private final String openId = "1212321";

    @Test
    public void saveProductCategory(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("花鱼");
        productInfo.setProductPrice(new BigDecimal(213.21));
        productInfo.setProductStock(2112);
        productInfo.setProductDescription("好吃不贵");
        productInfo.setProductIcon("123");
        productInfo.setCategorytype("123");

        ProductInfo result = repository.save(productInfo);
//        return result;
        Assert.assertNotNull(result);//判断是否为空
    }
}
