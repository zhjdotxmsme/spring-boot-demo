package com.example.demo.realm;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月01日 11:39
 * @modified By
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        //获取登录用户名
        String name = (String) collection.getPrimaryPrincipal();
        //查询用户名
        User user = userService.findByUsername(name);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        for (Role role : user.getRoles()) {
            info.addRole(role.getRoleName());
//            for (Permission permission : role.getPermissions()) {
//                info.addStringPermission(permission.getPermission());
//            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token.getPrincipal() == null) {
            return null;
        }
        String name = token.getPrincipal().toString();
        //查询用户名
        User user = userService.findByUsername(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
            return info;
        }
    }
}
