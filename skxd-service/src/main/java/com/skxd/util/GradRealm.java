package com.skxd.util;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shang-pc on 2015/11/25.
 */
public class GradRealm extends AuthorizingRealm {

    public GradRealm() {
        super();
        //设置认证token的实现类
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        //设置加密算法
        setCredentialsMatcher(new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME));
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
        List<String> roles=new ArrayList<>();
        List<String> permissions=new ArrayList<>();
        roles.add("admin");
        permissions.add("/admin/common/index");
        result.addRoles(roles);
        result.addStringPermissions(permissions);
        return result;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        User user = securityApplication.findby(upToken.getUsername());
//        if (user != null) {
//            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
//        }
        return new SimpleAuthenticationInfo("admin","123456", getName());
    }
}