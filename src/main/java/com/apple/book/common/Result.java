package com.apple.book.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;    // 200 为成功，其他为失败
    private String msg;      // 提示信息
    private T data;          // 查询到的具体数据

    // 成功时的快捷返回
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    // 失败时的快捷返回
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}