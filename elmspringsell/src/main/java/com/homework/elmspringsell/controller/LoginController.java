package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.SellerInfo;
import com.homework.elmspringsell.form.SellerForm;
import com.homework.elmspringsell.service.Impl.ProductInfoServiceImpl;
import com.homework.elmspringsell.service.ProductCategoryService;
import com.homework.elmspringsell.service.SellerInfoService;
import com.homework.elmspringsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SellerInfoService sellerInfoService;

    @GetMapping("/center/home")
    public ModelAndView view(){
        return new ModelAndView("login/home");
    }

    @GetMapping("/seller")
    public ModelAndView login(){
        return new ModelAndView("login/login");
    }

    @GetMapping("/register")
    public ModelAndView register(Map<String,Object> map){
        return new ModelAndView("login/register",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid SellerForm form, BindingResult bindingResult,Map<String,Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/login/seller");
            return new ModelAndView("common/error", map);
        }
        if (StringUtils.isEmpty(form.getId())){
            SellerInfo sellerInfo = new SellerInfo();
            BeanUtils.copyProperties(form,sellerInfo);
            sellerInfo.setId(KeyUtil.genUniqueKey());
            sellerInfoService.save(sellerInfo);
            return new ModelAndView("login/login",map);
        }
        else {
            if (sellerInfoService.findOne(form.getId())==null){
                map.put("msg", "用户不存在!");
                map.put("url", "/sell/login/register");
                return new ModelAndView("common/error", map);
            }

        }

        if (form.getPassword().equals(sellerInfoService.findPassWordById(form.getId()))){
            map.put("msg", "欢迎"+sellerInfoService.findSellerNameById(form.getId())+"回来！");
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/success", map);
        }
        else {
            map.put("msg", "Id密码错误!");
            map.put("url", "/sell/login/seller");
            return new ModelAndView("common/error", map);
        }
    }
}
