package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTests {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findAll(){
        List<ProductInfo> infoList = repository.findAll();
        for (ProductInfo e:infoList){
            System.out.println(e);
        }
    }


}
