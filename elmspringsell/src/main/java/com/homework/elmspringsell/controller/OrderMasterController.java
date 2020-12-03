package com.homework.elmspringsell.controller;

import com.homework.elmspringsell.dataobject.OrderDetail;
import com.homework.elmspringsell.dataobject.OrderMaster;
import com.homework.elmspringsell.form.MasterForm;
import com.homework.elmspringsell.service.OrderDetailService;
import com.homework.elmspringsell.service.OrderMasterService;
import com.homework.elmspringsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("seller/order")
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/list")
    public ModelAndView listAll(@RequestParam(value = "page" ,defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "4") Integer size
            , Map<String,Object> map){

        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderMaster> orderMasterPage = orderMasterService.findAll(pageRequest);
        map.put("orderMasterPage",orderMasterPage);
        map.put("currentPage",page);
        map.put("size",size);

        return new ModelAndView("order/list",map);
    }

    @GetMapping("/move")
    public ModelAndView move(@RequestParam("orderId") String orderId,Map<String,Object> map){
        OrderMaster orderMaster = orderMasterService.findOne(orderId);
        if (orderMaster.getOrderStatus()!=0){
            map.put("msg", "订单状态错误！");
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        else {
            orderMaster.setOrderStatus(2);
            orderMasterService.save(orderMaster);
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/success", map);
        }
    }

    @GetMapping("/index")
    public ModelAndView save(@RequestParam(value = "orderId",required = false) String orderId,
                             Map<String,Object> map){
        OrderMaster orderMaster = new OrderMaster();
        if (!StringUtils.isEmpty(orderId)){
            orderMaster = orderMasterService.findOne(orderId);
        }
        map.put("orderMaster",orderMaster);
        return new ModelAndView("order/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid MasterForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){

        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/order/index");
            return new ModelAndView("common/error", map);
        }

        OrderMaster orderMaster = new OrderMaster();
        if (!StringUtils.isEmpty(form.getOrderId())){
            orderMaster = orderMasterService.findOne(form.getOrderId());
            orderMaster.setUpdateTime(null);
        }else {
            form.setOrderId(KeyUtil.genUniqueKey());
        }

        BeanUtils.copyProperties(form, orderMaster);
        orderMasterService.save(orderMaster);
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);

    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                             Map<String,Object> map){
        OrderMaster orderMaster = orderMasterService.findOne(orderId);
        map.put("orderMaster",orderMaster);
        List<OrderDetail> orderDetailList = orderDetailService.findOneByOrderId(orderId);
        map.put("orderDetailList",orderDetailList);
        return new ModelAndView("order/detail",map);
    }

}
