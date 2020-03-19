package com.wang.springboot.sys.common;

import com.wang.springboot.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/17 11:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActiveUser {

    private User user;

    private List<String> roles;

    private List<String> permissions;


}
