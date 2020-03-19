package com.wang.springboot.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.springboot.sys.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王一宁
 * @since 2019-11-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
