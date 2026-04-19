package com.apple.book.service.impl;

import com.apple.book.entity.Book;
import com.apple.book.entity.MonthlyStats;
import com.apple.book.mapper.BookMapper;
import com.apple.book.mapper.MonthlyStatsMapper;
import com.apple.book.service.IBookService;
import com.apple.book.service.IMonthlyStats;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthlyStatsImpl extends ServiceImpl<MonthlyStatsMapper, MonthlyStats> implements IMonthlyStats {
}
