package com.neusoft.springbootsell.service.Impl;


import com.neusoft.springbootsell.dataobject.Productinfo;
import com.neusoft.springbootsell.services.Impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServicesTests {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne(){
        String id = "402809817604862001760486296a0000";
        Productinfo productinfo = productService.findOne(id);
//        System.out.println(productinfo);
        System.out.println("==============================================");
        Assert.assertEquals("40280981760486200100",productinfo.getProductId());
    }
}
