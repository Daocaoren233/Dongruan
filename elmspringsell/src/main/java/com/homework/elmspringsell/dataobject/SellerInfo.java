package com.homework.elmspringsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class SellerInfo {
    @Id
    private String Id;

    private String username;

    private String password;

    private String openid;

    private Timestamp createTime;

    private Timestamp updateTime;

}
