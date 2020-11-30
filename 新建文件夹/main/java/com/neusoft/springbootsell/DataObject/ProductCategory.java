package com.neusoft.springbootsell.DataObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 *商品类目
 */
@Entity
@Data
@NoArgsConstructor
@DynamicUpdate   //动态更新
public class ProductCategory {
//    类目id
    @Id
    @GeneratedValue
    private Integer categoryId;

//    类目名
    private String categoryName;

//    类目编号
    private String categoryType;
//    创建时间
    private Date createTime;
//    更新时间
    private Date updateTime;

    public ProductCategory(String cateGoryName,String cateGorytype){
        this.categoryName = cateGoryName;
        this.categoryType = cateGorytype;
    }









}
