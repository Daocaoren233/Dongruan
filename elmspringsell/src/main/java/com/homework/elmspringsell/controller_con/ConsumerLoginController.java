package com.homework.elmspringsell.controller_con;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumer/login")
public class ConsumerLoginController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/home")
    public ModelAndView home(Map<String,Object> map){
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("consumerlogin/home",map);
    }
}
