package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
public class ProductInfo {

    @Id
    private String product_id;

    /** 商品名字 */
    private String product_name;

    /** 单价 */
    private BigDecimal product_price;

    /** 库存 */
    private Integer product_stock;

    /** 描述 */
    private String product_description;

    /** 小图 */
    private String product_icon;

    /** 状态 0正常 1下架 */
    private Integer product_status;

    /** 类目编号 */
    private Integer category_type;

    /** 创建时间 */
    private Timestamp create_time;

    /** 更新时间 */
    private Timestamp update_time;

}
