package com.homework.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTests {

    @Autowired
    private LuckyMoneyRepository repository;

    @Test
    public void listAll(){
        List<LuckyMoney> list = repository.findAll();
        for (LuckyMoney e:list){
            System.out.println(e);
        }

    }

    @Test
    public void getById(){
//        System.out.print("输入Id: ");
//        int id = input.nextInt();
        System.out.println(repository.findById(2));
        return;
    }

    @Test
    public void deleteById(){
        repository.deleteById(4);
        return;
    }

    @Test
    public void save(){
        LuckyMoney money = new LuckyMoney();
        money.setConsumer("sss");
        money.setProducer("mas");
        money.setMoney(new BigDecimal(23));
        repository.save(money);
        return;

    }

}
