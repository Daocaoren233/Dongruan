package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.service.Impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @GetMapping("/list")
    public List<ProductInfo> listAll(){
        return productInfoService.findUpAll();
    }

    @GetMapping("/find/{Id}")
    public ProductInfo findById(@PathVariable("Id") String Id){
        return productInfoService.findOne(Id);
    }

}
