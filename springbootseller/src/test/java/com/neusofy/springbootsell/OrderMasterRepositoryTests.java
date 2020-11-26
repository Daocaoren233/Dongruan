package com.neusofy.springbootsell;

import com.neusofy.springbootsell.dataobject.OrderMaster;
import com.neusofy.springbootsell.repository.OrderMasterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTests {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("王明");
        orderMaster.setBuyerPhone("16392893274");
        orderMaster.setBuyerAddress("江科大围栏");
        orderMaster.setBuyerOpenId("12345");
        orderMaster.setOderAmount(new BigDecimal(23.4));
        repository.save(orderMaster);
        return;

    }
}
