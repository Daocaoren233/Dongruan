package com.homework.elmspringsell.controller_con;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.dataobject.SellerInfo;
import com.homework.elmspringsell.form.SellerForm;
import com.homework.elmspringsell.service.ProductInfoService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumer/login")
public class ConsumerLoginController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private SellerInfoService sellerInfoService;

    @GetMapping("/home")
    public ModelAndView home(Map<String,Object> map){
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("consumerlogin/home",map);
    }

    @GetMapping("/homeed")
    public ModelAndView homeed(Map<String,Object> map){
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("sellerList-and-productList/homeed",map);
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("consumerlogin/login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("consumerlogin/register");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid SellerForm form, BindingResult bindingResult, Map<String,Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/consumer/login/login");
            return new ModelAndView("common/error", map);
        }
        if (StringUtils.isEmpty(form.getId())){
            SellerInfo sellerInfo = new SellerInfo();
            BeanUtils.copyProperties(form,sellerInfo);
            sellerInfo.setId(KeyUtil.genUniqueKey());
            sellerInfoService.save(sellerInfo);
            return new ModelAndView("consumerlogin/login",map);
        }
        else {
            if (sellerInfoService.findOne(form.getId())==null){
                map.put("msg", "用户不存在!");
                map.put("url", "/sell/consumer/login/register");
                return new ModelAndView("common/error", map);
            }

        }

        if (form.getPassword().equals(sellerInfoService.findPassWordById(form.getId()))){
            map.put("msg", "欢迎"+sellerInfoService.findSellerNameById(form.getId())+"！今天想吃什么呢？");
            map.put("url", "/sell/consumer/login/homeed");
            return new ModelAndView("common/success", map);
        }
        else {
            map.put("msg", "Id密码错误!");
            map.put("url", "/sell/consumer/login/login");
            return new ModelAndView("common/error", map);
        }
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("sellerId") String sellerId, Map<String,Object> map){
        String name = sellerInfoService.findSellerNameById(sellerId);
        map.put("name",name);
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("sellerList-and-productList/sellerProduct",map);
    }

}
