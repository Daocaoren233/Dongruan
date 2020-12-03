package com.homework.elmspringsell.repositorytest;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTests {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findAll(){
        List<ProductInfo> list = repository.findAll();
        for (ProductInfo e:list){
            System.out.println(e);
        }
    }

    @Test
    public void findByProductStatusIn(){
        List<ProductInfo> list = repository.findByProductStatusIn(0);
        for (ProductInfo e:list){
            System.out.println(e);
        }
    }

    @Test
    public void findOne(){
        System.out.println(repository.findOne("123456"));
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("8578578571");
        productInfo.setProductName("梁祝");
        productInfo.setProductPrice(new BigDecimal(88.8));
        productInfo.setCategoryType(4);
        productInfo.setProductDescription("很好看");
        productInfo.setProductIcon("http://...");
        productInfo.setProductStock(45);
        repository.save(productInfo);
    }

    @Test
    public void update(){
        ProductInfo productInfo = repository.findOne("8578578571");
        productInfo.setUpdateTime(null);
        repository.save(productInfo);
    }

    @Test
    public void delete(){
        repository.delete("1606875658419602590");
    }

}
