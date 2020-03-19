package com.wang.springboot.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.springboot.sys.domain.News;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 王一宁
 * @date 2020/3/19 9:34
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
