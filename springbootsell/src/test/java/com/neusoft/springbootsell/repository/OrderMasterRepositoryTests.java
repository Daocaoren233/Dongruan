package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.OrderMaster;
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
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyer_name("王明1");
        orderMaster.setBuyer_phone("16392893274");
        orderMaster.setBuyer_address("江科大围栏");
        orderMaster.setBuyer_openid("123456");
        orderMaster.setOrder_amount(new BigDecimal(23.6));
        repository.save(orderMaster);
        return;

    }

    @Test
    public void getById(){
        String id = "1222222222";
        System.out.println(repository.findOne(id));
        return;
    }

    @Test
    public void updateById(){
        String id = "40280981760480360176048040a40000";
        OrderMaster orderMaster = repository.findOne(id);
        orderMaster.setBuyer_name("王霞分");
        repository.save(orderMaster);
        return;
    }

    @Test
    public void delete(){
        String id = "40280981760480360176048040a40000";
        repository.delete(id);
        return;
    }

    @Test
    public void listAll(){
        List<OrderMaster> orderMasterList = repository.findAll();
        for (OrderMaster e:orderMasterList){
            System.out.println(e);
        }
    }
}
