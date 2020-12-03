package com.homework.elmspringsell.dataobject;


import com.homework.elmspringsell.enums.OrderStatusEnum;
import com.homework.elmspringsell.enums.PayStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单主表
 */
@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class OrderMaster {
    /** 订单id */
    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Timestamp createTime;

    private Timestamp updateTime;

}
