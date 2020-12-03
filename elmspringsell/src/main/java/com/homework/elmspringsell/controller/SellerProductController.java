package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.ProductCategory;
import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.exception.SellException;
import com.homework.elmspringsell.form.ProductForm;
import com.homework.elmspringsell.service.Impl.ProductInfoServiceImpl;
import com.homework.elmspringsell.service.ProductCategoryService;
import com.homework.elmspringsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ModelAndView listAll(@RequestParam(value = "page" ,defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "4") Integer size
            , Map<String,Object> map){

        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("product/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId
            ,Map<String,Object> map){
        if (!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo",productInfo);
        }
        else {
            ProductInfo productInfo = new ProductInfo();
            map.put("productInfo",productInfo);
        }

        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("categoryList",productCategoryList);
        return new ModelAndView("product/index",map);

    }


    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){

        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            //        productInfo.setProductName(form.getProductName());
            if (!StringUtils.isEmpty(form.getProductId())){
                // 有ProductId  修改
                productInfo = productInfoService.findOne(form.getProductId());
                productInfo.setUpdateTime(null);
            }else {
                // 新增  生成一个id
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form, productInfo);
            productInfoService.save(productInfo);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }

    @GetMapping("/sale")
    public ModelAndView sale(@RequestParam("productId") String productId,
                             @RequestParam("productStatus") Integer productStatus,
                                     Map<String,Object> map){
        ProductInfo productInfo = productInfoService.findOne(productId);
        if (productStatus == 1){
            productInfo.setProductStatus(0);
        }
        else {
            productInfo.setProductStatus(1);
        }
        productInfoService.save(productInfo);
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }



}
