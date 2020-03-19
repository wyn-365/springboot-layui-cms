package com.wang.springboot.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wang.springboot.sys.common.DataGridView;
import com.wang.springboot.sys.common.ResultObj;
import com.wang.springboot.sys.domain.Dept;
import com.wang.springboot.sys.domain.News;
import com.wang.springboot.sys.service.NewsService;
import com.wang.springboot.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王一宁
 * @date 2020/3/19 9:25
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("listNews")
    public DataGridView listNews(NewsVo newsVo){
        //分页显示
        IPage<News> page = new Page<>(newsVo.getPage(),newsVo.getLimit());
        //查询数据
        newsService.page(page);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

}
