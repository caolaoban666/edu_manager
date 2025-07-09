package com.ty.hh.edu.model.req;

import lombok.Data;

@Data
public class StudentPageRequest {
    private String name;     // 可选搜索字段
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}

