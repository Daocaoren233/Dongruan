package com.homework.elmspringsell.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryForm {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;
}
