package com.apple.book.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
// 必须设置 autoResultMap = true，否则无法将 JSON 自动转回 List 对象
@TableName(value = "monthly_stats", autoResultMap = true)
public class MonthlyStats {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String statMonth;

    private Integer booksCount;

    private Integer hoursCount;

    private Integer reviewsCount;

    private LocalDateTime updatedAt;
}
