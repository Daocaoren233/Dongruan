package com.homework.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LuckgMoneyController {

    @Autowired
    private LuckyMoneyRepository repository;

//    @GetMapping("/list")
    @RequestMapping("/list")
    public List<LuckyMoney> listAll(){

        List<LuckyMoney> luckyMoneyList = repository.findAll();
        return luckyMoneyList;
    }

    public LuckyMoney postRedBag(String producer, BigDecimal money){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return repository.save(luckyMoney);
    }

}
