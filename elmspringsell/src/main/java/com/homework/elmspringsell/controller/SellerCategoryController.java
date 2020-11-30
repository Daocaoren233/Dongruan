package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.ProductCategory;
import com.homework.elmspringsell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
//@ResponseBody
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> list = productCategoryService.findAll();
        map.put("categoryList",list);
        return new ModelAndView("category/listxiesi",map);

    }
}
