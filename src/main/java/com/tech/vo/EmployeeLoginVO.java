package com.tech.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeLoginVO {

    private Long id;

    private String userName;

    private String name;

    private String token;
}
