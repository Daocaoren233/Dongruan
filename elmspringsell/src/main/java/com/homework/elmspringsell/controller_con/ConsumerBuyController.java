package com.homework.elmspringsell.controller_con;

import com.homework.elmspringsell.dataobject.ProductInfo;
import com.homework.elmspringsell.dataobject.SellerInfo;
import com.homework.elmspringsell.dataobject.ShopCart;
import com.homework.elmspringsell.service.ProductInfoService;
import com.homework.elmspringsell.service.SellerInfoService;
import com.homework.elmspringsell.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumer/buy")
public class ConsumerBuyController {
    @Autowired
    private SellerInfoService sellerInfoService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ShopCartService shopCartService;

    @GetMapping("/sellers")
    public ModelAndView sellers(Map<String,Object> map){
        List<SellerInfo> sellerInfoList = sellerInfoService.findAll();
        map.put("sellerInfoList",sellerInfoList);
        return new ModelAndView("sellerList-and-productList/sellerlist",map);

    }

    @GetMapping("/sellersed")
    public ModelAndView sellersed(Map<String,Object> map){
        List<SellerInfo> sellerInfoList = sellerInfoService.findAll();
        map.put("sellerInfoList",sellerInfoList);
        return new ModelAndView("sellerList-and-productList/sellerlisted",map);

    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "sellerId",required = true) String sellerId, Map<String,Object> map){
        String name = sellerInfoService.findSellerNameById(sellerId);
        map.put("name",name);
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("sellerList-and-productList/sellerProduct",map);
    }

    @GetMapping("/detailed")
    public ModelAndView detailed(@RequestParam(value = "sellerId",required = true) String sellerId, Map<String,Object> map){
        String name = sellerInfoService.findSellerNameById(sellerId);
        map.put("name",name);
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        map.put("productInfoList",productInfoList);
        return new ModelAndView("sellerList-and-productList/sellerProducted",map);
    }

    @GetMapping("/order")
    public ModelAndView order(Map<String,Object> map){
        List<ShopCart> shopCartList = shopCartService.findAll();
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (ShopCart shopCart:shopCartList){
            ProductInfo productInfo = productInfoService.findOne(shopCart.getProductId());
            productInfoList.add(productInfo);
        }
        map.put("productInfoList",productInfoList);
        return new ModelAndView("sellerList-and-productList/ordered",map);
    }

    @GetMapping("/saveorder")
    public ModelAndView saveorder(@RequestParam(value = "productId",required = true) String productId,Map<String,Object> map){
        ShopCart shopCart = new ShopCart();
        shopCart.setProductId(productId);
        shopCartService.save(shopCart);
        map.put("url", "/sell/consumer/login/homeed");
        return new ModelAndView("common/successed", map);

    }

    @GetMapping("/overorder")
    public ModelAndView overorder(Map<String,Object> map){
        shopCartService.deleteAll();
        map.put("url", "/sell/consumer/login/homeed");
        return new ModelAndView("common/successed", map);
    }

//    @GetMapping("/saveorder")
//    public void saveorder(@RequestParam(value = "productId",required = true) String productId){
//        ShopCart shopCart = new ShopCart();
//        shopCart.setProductId(productId);
//        shopCartService.save(shopCart);
//        return;
//    }


}
