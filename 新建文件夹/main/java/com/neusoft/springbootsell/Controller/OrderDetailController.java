package com.neusoft.springbootsell.Controller;

import com.neusoft.springbootsell.DataObject.OrderDetail;
import com.neusoft.springbootsell.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class OrderDetailController {
    @Autowired
    private OrderDetailRepository repository;

    @GetMapping("/product/list")
    public List<OrderDetail> showAll(){
        return repository.findAll();
    }
//    @PostMapping("/order/create")
//    public save(String name, String )

}
