package com.apple.book.mapper;

import com.apple.book.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    // 继承 BaseMapper 后，普通的增删改查已经自动拥有了，无需写 SQL
}