package com.apple.book.controller;

import com.apple.book.common.Result;
import com.apple.book.entity.Book;
import com.apple.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
// 解决跨域问题，允许前端（如 localhost:5173）访问
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 获取所有书籍列表
     */
    @GetMapping("/getAllBooks")
    public Result getAllBooks() {
        List<Book> bookList = bookService.list();
        return Result.success(bookList);
    }

    /**
     * 根据ID获取书籍详情
     */
    @GetMapping("/{id}")
    public Result<Long> getBookById(@PathVariable Long id) {
        return Result.success(id);
    }
}