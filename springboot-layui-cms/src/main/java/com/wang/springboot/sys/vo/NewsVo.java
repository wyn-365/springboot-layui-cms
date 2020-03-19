package com.wang.springboot.sys.vo;

import com.wang.springboot.sys.domain.News;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 王一宁
 * @date 2020/3/19 9:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsVo extends News {

    private Integer page=1;
    private Integer limit=10;
}
