package com.wang.springboot.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.springboot.sys.domain.Dept;
import com.wang.springboot.sys.domain.News;
import com.wang.springboot.sys.mapper.DeptMapper;
import com.wang.springboot.sys.mapper.NewsMapper;
import com.wang.springboot.sys.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王一宁
 * @date 2020/3/19 9:31
 */
@Service
@Transactional
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
}
