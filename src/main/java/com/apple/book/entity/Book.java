package com.apple.book.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
// 必须设置 autoResultMap = true，否则无法将 JSON 自动转回 List 对象
@TableName(value = "books", autoResultMap = true)
public class Book {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;
    private String author;
    private String category;
    private String intro;

    // 对应数据库的 JSON 字段，自动处理 List <-> String 的转换
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> tags;

    private LocalDate date; // 对应数据库的 DATE 类型

    @TableField("read_time") // 如果字段名不一致可以用此注解强制映射
    private String readTime;

    private String cover;
    private Integer rating;
    private String href;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> content;
}