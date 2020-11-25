package com.homework.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bag")
public class LuckgMoneyController {

    @Autowired
    private LuckyMoneyRepository repository;

//    @GetMapping("/list")
    @RequestMapping("/list")
    public List<LuckyMoney> listAll(){

        List<LuckyMoney> luckyMoneyList = repository.findAll();
        return luckyMoneyList;
    }


    @GetMapping("/save")
    public LuckyMoney postRedBag(@RequestParam(value = "pro",required = true) String producer,@RequestParam(value = "mon",required = true) BigDecimal money){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return repository.save(luckyMoney);
    }

    @GetMapping("/find/{id}")
    public LuckyMoney findById(@PathVariable("id") Integer id){
//        Optional<LuckyMoney> optional = repository.findById(id);
//        LuckyMoney luckyMoney = optional.get();
//        return luckyMoney;
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id")Integer id,@RequestParam(value = "consumer",required = true) String consumer){
        Optional<LuckyMoney> optional = repository.findById(id);
        if (optional.isPresent()){
            LuckyMoney luckyMoney = optional.get();
            luckyMoney.setConsumer(consumer);
            return repository.save(luckyMoney);
        }
        return null;
    }

}
