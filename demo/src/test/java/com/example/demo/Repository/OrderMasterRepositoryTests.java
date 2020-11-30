package com.example.demo.Repository;

import com.example.demo.DataObject.OrderMaster;
import com.example.demo.repository.OrderMasterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTests {

    @Autowired
    OrderMasterRepository repository;
    private final String openId = "1212321";

//    @Test
//    public void saveOrderMaster(){
//        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setOrderId("123321");
//        orderMaster.setBuyerName("小杰");
//        orderMaster.setBuyerPhone("17361828245");
//        orderMaster.setBuyerAddress("江科大");
//        orderMaster.setBuyerOpenid(openId);
//        orderMaster.setOrderAmount(new BigDecimal(9.9));
//        OrderMaster result = repository.save(orderMaster);
////        return result;
//        Assert.assertNotNull(result);//判断是否为空
//    }
    @Test
    public void findAll(){
        List<OrderMaster> productCategoryList = repository.findAll();
        for (OrderMaster e:productCategoryList){
            System.out.println(e);
        }
    }
}
