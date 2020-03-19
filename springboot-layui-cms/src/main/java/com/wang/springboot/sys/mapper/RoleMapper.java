package com.wang.springboot.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.springboot.sys.domain.Role;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王一宁
 * @since 2019-11-28
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色ID删除sys_role_permission表中的数据
     * @param id 角色的id
     */
    @Delete("delete from sys_role_permission where rid = #{pid}")
    void deleteRolePermissionByRid(@Param("pid") Serializable id);

    /**
     * 根据角色ID删除sys_user_role表中的数据
     * @param id 角色的id
     */
    @Delete("delete from sys_user_role where rid = #{pid}")
    void deleteUserRoleByRid(@Param("pid") Serializable id);

    /**
     * 根据角色ID查询当前角色拥有的菜单ID和权限ID
     * @param roleId
     * @return
     */
    @Select("select pid from sys_role_permission where rid = #{roleId}")
    List<Integer> queryRolePermissionIdsByRid(@Param("roleId") Integer roleId);

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid
     * @param pid
     */
    @Insert("insert into sys_role_permission(rid,pid) values (#{rid},#{pid})")
    void saveRolePermission(@Param("rid") Integer rid, @Param("pid") Integer pid);

    /**
     * 根据用户id删除用户角色中间表的数据
     * @param id
     */
    @Delete("delete from sys_user_role where uid = #{id}")
    void deleteRoleUserByUid(@Param("id") Serializable id);

    /**
     * 查询当前用户拥有的角色ID集合
     * @param id
     * @return
     */
    @Select("select rid from sys_user_role where uid = #{id}")
    List<Integer> queryUserRoleIdsByUid(@Param("id") Integer id);

    /**
     * 保存用户和角色的关系
     * @param uid 用户的ID
     * @param rid 用户拥有的角色的ID的数组
     */
    @Insert("insert into sys_user_role(uid,rid) values (#{uid},#{rid})")
    void insertUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
