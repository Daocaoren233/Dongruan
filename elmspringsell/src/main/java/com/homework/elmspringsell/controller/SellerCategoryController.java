package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.ProductCategory;
import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.exception.SellException;
import com.homework.elmspringsell.form.CategoryForm;
import com.homework.elmspringsell.form.ProductForm;
import com.homework.elmspringsell.service.ProductCategoryService;
import com.homework.elmspringsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        return new ModelAndView("category/list",map);

    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false)Integer categoryId,
                              Map<String,Object> map){
        ProductCategory productCategory = new ProductCategory();
        if (categoryId != null){
            productCategory = productCategoryService.findOne(categoryId);
        }
        map.put("category",productCategory);

        return new ModelAndView("category/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){

        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if (form.getCategoryId() != null){
                // 有ProductId  修改
                productCategory = productCategoryService.findOne(form.getCategoryId());
                productCategory.setUpdateTime(null);
            }

            BeanUtils.copyProperties(form, productCategory);
            productCategoryService.save(productCategory);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);

    }
}
