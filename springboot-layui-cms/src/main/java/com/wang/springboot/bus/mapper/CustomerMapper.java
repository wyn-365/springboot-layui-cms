package com.wang.springboot.bus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.springboot.bus.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luoyi-
 * @since 2019-12-05
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
