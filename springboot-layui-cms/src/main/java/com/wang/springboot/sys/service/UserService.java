package com.wang.springboot.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.springboot.sys.domain.User;

/**
 * @author 王一宁
 * @since 2019-11-21
 */
public interface UserService extends IService<User> {

    /**
     * 保存用户和角色的关系
     * @param uid 用户的ID
     * @param ids 用户拥有的角色的ID的数组
     */
    void saveUserRole(Integer uid, Integer[] ids);

    /**
     * 查询当前用户是否是其他用户的直属领导
     * @param userId
     * @return
     */
    Boolean queryMgrByUserId(Integer userId);

    void deleteUserById(Integer id);
}
