package com.neusoft.springbootsell.Controller;


import com.neusoft.springbootsell.DataObject.ProductCategory;
import com.neusoft.springbootsell.Service.CateoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CateoryService service;


    @GetMapping("/list/all")
    public String showAll(){
        List<ProductCategory> list = service.findAll();
        String result = "word!";
//        for(ProductCategory p:list)
//        {
////            System.out.println(p);
//        }
        return  result;
    }
    @GetMapping("/list")
    public ModelAndView showList(Map<String,Object> map){
        List<ProductCategory> list = service.findAll();
        //将list添加到map中
        map.put("categoryList",list);
        return new ModelAndView("categpry/listxiesi",map);
    }
}
