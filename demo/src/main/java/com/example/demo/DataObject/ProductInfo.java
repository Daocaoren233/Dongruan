package com.example.demo.DataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *商品详情
 */
@Entity
@Data
@DynamicUpdate   //动态更新
public class    ProductInfo {
//    商品id
    @Id
    private String productId;

//    商品名称
    private String productName;
//    单价
    private BigDecimal productPrice;
//    库存
    private  Integer productStock;
//    描述
    private String  productDescription;
//    小图
    private String productIcon;
//    状态 0 正常 1 下架
    private Integer productStatus = 0;
//    类目编号
    private String categorytype;
//    创建时间
    private Date createTime;
//    更新时间
    private Date updateTime;


}

