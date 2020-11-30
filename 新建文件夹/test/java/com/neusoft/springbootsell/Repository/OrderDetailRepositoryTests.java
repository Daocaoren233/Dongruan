package com.neusoft.springbootsell.Repository;

import com.neusoft.springbootsell.DataObject.OrderDetail;
import com.neusoft.springbootsell.repository.OrderDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTests {

    @Autowired
    OrderDetailRepository repository;
    private final String openId = "1212321";

    @Test
    public void saveOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("0001");
        orderDetail.setOrderId("1");
        orderDetail.setProductId("12");
        orderDetail.setProductName("小丸子");
        orderDetail.setProductPrice(new BigDecimal(8.0));
        orderDetail.setProductQuantity(13);
        OrderDetail result = repository.save(orderDetail);
//        return result;
        Assert.assertNotNull(result);//判断是否为空
    }
}
