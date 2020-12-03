package com.homework.elmspringsell.dataobject;

import com.homework.elmspringsell.enums.ProductStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus= ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Timestamp createTime;

    private Timestamp updateTime;
}
