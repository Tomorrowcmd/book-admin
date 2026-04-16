package com.apple.book.service.impl;

import com.apple.book.entity.Book;
import com.apple.book.mapper.BookMapper;
import com.apple.book.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service // 必须加这个注解，让 Spring 管理这个类
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    // 继承 ServiceImpl 后，你已经拥有了 list(), getById(), save(), update() 等所有常用功能
}