package com.ty.hh.edu.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code;       // 状态码，200 表示成功
    private String message; // 提示信息
    private T data;         // 返回数据体

    // 成功返回，带数据
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("success");
        r.setData(data);
        return r;
    }

    // 成功返回，自定义消息
    public static <T> Result<T> success(String message) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage(message);
        return r;
    }

    // 失败返回，自定义消息
    public static <T> Result<T> failure(String message) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }
}
// 失败返回，自定义状
