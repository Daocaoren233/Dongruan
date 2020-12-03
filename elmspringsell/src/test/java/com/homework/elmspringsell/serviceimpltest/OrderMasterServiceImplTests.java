package com.homework.elmspringsell.serviceimpltest;

import com.homework.elmspringsell.dataobject.OrderMaster;
import com.homework.elmspringsell.enums.OrderStatusEnum;
import com.homework.elmspringsell.enums.PayStatusEnum;
import com.homework.elmspringsell.service.Impl.OrderMasterServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterServiceImplTests {
    @Autowired
    private OrderMasterServiceImpl orderMasterService;

//    @Test
//    public void findAll(){
//        List<OrderMaster> orderMasterList = orderMasterService.findAll();
//        for (OrderMaster e:orderMasterList){
//            System.out.println(e);
//        }
//    }

    @Test
    public void findByOrderStatus(){
        List<Integer> orderStatusList = Arrays.asList(OrderStatusEnum.NEW.getCode());
        List<OrderMaster> orderMasterList = orderMasterService.findByOrderStatus(orderStatusList);
        for (OrderMaster e:orderMasterList){
            System.out.println(e);
        }
    }

    @Test
    public void findByPayStatus(){
        List<Integer> payStatusList = Arrays.asList(PayStatusEnum.WAIT.getCode());
        List<OrderMaster> orderMasterList = orderMasterService.findByPayStatus(payStatusList);
        for (OrderMaster e:orderMasterList){
            System.out.println(e);
        }
    }

    @Test
    public void findOne(){
        System.out.println(orderMasterService.findOne("857857857"));
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
        System.out.println(orderMasterService.save(orderMaster));
    }

    @Test
    public void deleteByOrderId(){
        orderMasterService.deleteByOrderId("857857857");
    }

    @Test
    public void update(){
        OrderMaster orderMaster = orderMasterService.findOne("857857857");
        orderMaster.setUpdateTime(null);
        orderMaster.setBuyerName("小不点");
        orderMasterService.save(orderMaster);
    }
}
