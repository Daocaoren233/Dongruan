package com.homework.elmspringsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ShopCart {
    @Id
    @GeneratedValue
    private Integer Id;

    private String productId;

    private Integer num;
}
