package com.wang.springboot.sys.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.springboot.sys.domain.Permission;
import com.wang.springboot.sys.mapper.PermissionMapper;
import com.wang.springboot.sys.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author 王一宁
 * @since 2019-11-22
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public boolean removeById(Serializable id) {

        //根据权限ID或菜单ID删除sys_role_permission表中的数据
        PermissionMapper permissionMapper = this.getBaseMapper();
        permissionMapper.deleteRolePermissionByPid(id);
        //删除权限表中的数据
        return super.removeById(id);
    }
}
