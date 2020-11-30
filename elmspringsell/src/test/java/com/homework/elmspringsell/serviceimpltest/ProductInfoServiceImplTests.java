package com.homework.elmspringsell.serviceimpltest;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.enums.ProductStatusEnum;
import com.homework.elmspringsell.service.Impl.ProductInfoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTests {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findUpAll(){
        List<ProductInfo> list = productInfoService.findUpAll();
        for (ProductInfo e:list){
            System.out.println(e);
        }
    }

//    @Test
//    public void findByProductStatusIn(){
//        List<ProductInfo> list = repository.findByProductStatusIn(0);
//        for (ProductInfo e:list){
//            System.out.println(e);
//        }
//    }
//
    @Test
    public void findOne(){
        ProductInfo productInfo = productInfoService.findOne("123456");
        System.out.println(productInfo);
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findAll(){
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
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
        ProductInfo res = productInfoService.save(productInfo);
        Assert.assertNotNull(res);
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productInfoService.onSale("8578578571");
        Assert.assertEquals(ProductStatusEnum.UP.getCode(),productInfo.getProductStatus());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productInfoService.offSale("8578578571");
        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(),productInfo.getProductStatus());
    }

}
