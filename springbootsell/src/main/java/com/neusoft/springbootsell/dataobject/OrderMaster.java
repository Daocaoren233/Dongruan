package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    @GenericGenerator(name = "OrderId",strategy = "uuid")
    @GeneratedValue(generator = "OrderId")
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
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    public OrderMaster(){}
}
