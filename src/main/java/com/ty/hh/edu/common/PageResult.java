package com.ty.hh.edu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> extends Result<T>{
    private long total;
    private long pageNo;
    private long pageSize;
    private List<T> list;
}

