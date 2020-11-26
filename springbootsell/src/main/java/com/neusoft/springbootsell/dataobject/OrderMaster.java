package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class OrderMaster {
    @Id
    @GenericGenerator(name = "OrderId",strategy = "uuid")
    @GeneratedValue(generator = "OrderId")
    private String order_id;

    private String buyer_name;

    private String buyer_phone;

    private String buyer_address;

    private String buyer_openid;

    /** 订单总金额 */
    private BigDecimal order_amount;

    /** 订单状态 默认为0 新下单 */
    private Integer order_status=0;

    /** 支付状态 默认为0 未支付 */
    private Integer pay_status=0;

    /** 创建时间 */
    private Timestamp create_time;

    /** 更新时间 */
    private Timestamp update_time;

}
