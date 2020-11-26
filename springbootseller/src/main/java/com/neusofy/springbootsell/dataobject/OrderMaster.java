package com.neusofy.springbootsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String OrderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    /** 订单总金额 */
    private BigDecimal oderAmount;

    /** 订单状态 默认为0 新下单 */
    private Integer orderStatus=0;

    /** 支付状态 默认为0 未支付 */
    private Integer payStatus=0;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public OrderMaster(){}
}
