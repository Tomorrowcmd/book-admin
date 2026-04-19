package com.apple.book.controller;


import com.apple.book.common.Result;
import com.apple.book.entity.Book;
import com.apple.book.entity.MonthlyStats;
import com.apple.book.service.IBookService;
import com.apple.book.service.IMonthlyStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
// 解决跨域问题，允许前端（如 localhost:5173）访问
@CrossOrigin(origins = "*")
public class MonthlyStatsController {
    @Autowired
    private IMonthlyStats monthlyStatsService;

    @Autowired
    private IBookService bookService;

    private static int count = 0;

    @GetMapping("/getAllStats")
    public Result getAllStats() {
        List<Book> bookList = bookService.list();
        bookList.stream().forEach(book -> {
            if (book.getContent() != null) {
                count++;
            }
        });
        MonthlyStats monthlyStats = monthlyStatsService.getById(1);
        monthlyStats.setReviewsCount(count);
        count = 0;
        monthlyStats.setBooksCount(bookList.size());

        return Result.success(monthlyStats);
    }
}
