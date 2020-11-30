package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单详情
 */
@Entity
@Data
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GenericGenerator(name = "detailId",strategy = "uuid")
    @GeneratedValue(generator = "detailId")
    private String detail_id;

    /**订单Id */
    private String order_id;

    /**商品Id */
    private String product_id;

    private String product_name;

    private BigDecimal product_price;

    private Integer product_quantity;

    private String product_icon;

    private Timestamp create_time;

    private Timestamp update_time;
}
