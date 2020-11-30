package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.service.Impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @GetMapping("/list")
    public ModelAndView listAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size
            , Map<String,Object> map){

        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("product/list",map);
    }
}
