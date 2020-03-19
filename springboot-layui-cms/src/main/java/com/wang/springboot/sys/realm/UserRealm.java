package com.wang.springboot.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.springboot.sys.common.ActiveUser;
import com.wang.springboot.sys.common.Constast;
import com.wang.springboot.sys.domain.Permission;
import com.wang.springboot.sys.domain.User;
import com.wang.springboot.sys.service.PermissionService;
import com.wang.springboot.sys.service.RoleService;
import com.wang.springboot.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 王一宁
 * @date 2020/3/17 11:04
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    @Lazy//只有使用的时候才会加载
    private PermissionService permissionService;

    @Autowired
    @Lazy
    private RoleService roleService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.查询数据库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname",token.getPrincipal().toString());
        User user = userService.getOne(queryWrapper);
        if (null != user){
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(user);

            //根据用户ID查询percode
            QueryWrapper<Permission> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("type", Constast.TYPE_PERMISSION);
            queryWrapper1.eq("available", Constast.AVAILABLE_TRUE);
            Integer userId = user.getId();
            //1.根据用户ID查询角色
            List<Integer> currentUserRoleIds = roleService.queryUserRoleIdsByUid(userId);
            //2.根据角色ID查询菜单ID和权限ID
            //使用set去重
            Set<Integer> pids = new HashSet<>();
            for (Integer rid : currentUserRoleIds) {
                //根据角色ID查询菜单ID和权限ID
                List<Integer> permissionIds = roleService.queryRolePermissionIdsByRid(rid);
                //将菜单ID和权限ID放入Set中去重
                pids.addAll(permissionIds);
            }
            List<Permission> list = new ArrayList<>();
            //3.根据角色ID查询权限
            if (pids.size()>0){
                queryWrapper1.in("id",pids);
                list = permissionService.list(queryWrapper1);
            }
            List<String> percodes = new ArrayList<>();
            for (Permission permission : list) {
                percodes.add(permission.getPercode());
            }
            //
            activeUser.setPermissions(percodes);

            //盐 时用户uuid生成的
            ByteSource salt = ByteSource.Util.bytes(user.getSalt());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,user.getPwd(),salt,this.getName());
            return info;
        }
        return null;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();
        User user = activeUser.getUser();
        List<String> permissions = activeUser.getPermissions();
        if (user.getType() == Constast.USER_TYPE_SUPER){
            authorizationInfo.addStringPermission("*:*");//所有权限
        }else {
            if (null != permissions && permissions.size()>0){
                authorizationInfo.addStringPermissions(permissions);
            }
        }
        return null;
    }


}
