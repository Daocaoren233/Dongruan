package com.homework.elmspringsell.repositorytest;

import com.homework.elmspringsell.dataobject.OrderMaster;
import com.homework.elmspringsell.repository.OrderMasterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTests {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findAll(){
        List<OrderMaster> orderMasterList = repository.findAll();
        for (OrderMaster e:orderMasterList){
            System.out.println(e);
        }
    }

    @Test
    public void findOne(){
        System.out.println(repository.findOne("857857857"));
    }

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("857857857");
        orderMaster.setBuyerName("上官婉儿");
        orderMaster.setBuyerAddress("王者峡谷");
        orderMaster.setBuyerOpenid("iloveyou");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setOrderAmount(new BigDecimal(88.8));
        System.out.println(repository.save(orderMaster));
    }

    @Test
    public void delete(){
        repository.delete("857857857");
    }

    @Test
    public void update(){
        OrderMaster orderMaster = repository.findOne("857857857");
        orderMaster.setUpdateTime(null);
        orderMaster.setBuyerName("小不点");
        repository.save(orderMaster);
    }



}
