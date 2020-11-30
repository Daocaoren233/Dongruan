package com.neusoft.springbootsell.DataObject;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Column;
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

    /* 订单Id*/

    private String orderId;

    /*商品Id*/

    private String productId;

    /*商品名称*/

    private String productName;

    /*商品单价*/

    private BigDecimal productPrice;

    /*商品数量*/

    private Integer productQuantity;

    /*商品图片*/

    private String productIcon;

}
