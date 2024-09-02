package com.tech.dto;

import lombok.Data;

@Data
public class DishPageQueryDTO {
    private int page;

    private int pageSize;

    private String name;

    //分类id
    private Integer categoryId;

    //状态 0表示禁用 1表示启用
    private Integer status;
}
