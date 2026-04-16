package com.apple.book.service;

import com.apple.book.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBookService extends IService<Book> {
    // 这里可以定义一些 Mapper 无法直接实现的复杂业务方法
    // 例如：void updateBookRating(Long id, Integer newRating);
}