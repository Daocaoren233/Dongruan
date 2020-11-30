package com.homework.elmspringsell.repositorytest;

import com.homework.elmspringsell.dataobject.OrderDetail;
import com.homework.elmspringsell.repository.OrderDetailRepository;
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
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findAll(){
        List<OrderDetail> list = repository.findAll();
        for (OrderDetail e:list){
            System.out.println(e);
        }
    }

    @Test
    public void findOne(){
        System.out.println(repository.findOne("8578578579"));
    }

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("8578578579");
        orderDetail.setOrderId("857857857");
        orderDetail.setProductIcon("http；//xxx.jpg");
        orderDetail.setProductId("8678678671");
        orderDetail.setProductName("末日机甲");
        orderDetail.setProductPrice(new BigDecimal(158.8));
        orderDetail.setProductQuantity(58);
        repository.save(orderDetail);
    }

    @Test
    public void update(){
        OrderDetail orderDetail = repository.findOne("8578578579");
        orderDetail.setUpdateTime(null);
        repository.save(orderDetail);
    }

    @Test
    public void delete(){
        repository.delete("8578578579");
    }
}
