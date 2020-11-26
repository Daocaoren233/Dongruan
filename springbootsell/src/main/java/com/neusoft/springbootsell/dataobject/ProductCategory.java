package com.neusoft.springbootsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 商品类目
 */
@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue
    private Integer category_id;

    /** 类目名 */
    private String category_name;

    /** 类目编号 */
    private Integer category_type;


    /** 创建时间 */
    private Timestamp create_time;

    /** 更新时间 */
    private Timestamp update_time;


    public ProductCategory(String category_name, Integer category_type) {
        this.category_name = category_name;
        this.category_type = category_type;
    }
}
