package com.homework.elmspringsell.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SellerForm {
    private String Id;

    private String username;

    private String password;

    private String openid;
}
