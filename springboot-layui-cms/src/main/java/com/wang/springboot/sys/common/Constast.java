package com.wang.springboot.sys.common;

/**
 * @author 王一宁
 * @date 2020/3/17 12:21
 */
public class Constast {
    /**
     * 状态码
     */
    public static final Integer OK = 200;
    public static final Integer ERROR = -1;
    /**
     * 菜单权限类型
     */
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "permission";
    /**
     * 可用状态
     */
    public static final Object AVAILABLE_TRUE = 1;
    public static final Object AVAILABLE_FALSE = 0;
    /**
     * 用户类型
     */
    public static final Integer USER_TYPE_SUPER = 0;
    public static final Integer USER_TYPE_NORMAL = 1;
    /**
     * 展开类型
     */
    public static final Integer OPEN_TRUE = 1;
    public static final Integer OPEN_FALSE = 0;
    /**
     * 重置密码的默认密码，和默认头像
     */
    public static final String USER_DEFAULT_PWD = "123456";
    public static final String DEFAULT_IMG_USER = "/resources/images/userface4.jpg";
    public static final int HASHITERATIONS = 123456;
    public static final String DEFAULT_IMG_GOODS ="/resources/images/userface4.jpg";
}
