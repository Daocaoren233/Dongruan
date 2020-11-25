package com.neusoft.springbootsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /**订单Id */
    private String orderId;

    /**商品Id */
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
