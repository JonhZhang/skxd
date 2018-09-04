package com.skxd.service;

import com.skxd.dao.*;
import com.skxd.model.*;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p>
 * Created by zzshang on 2015/11/25.
 */
public class SkxdAdminRealm extends AuthorizingRealm {

    @Autowired
    private SkxdAdminUserMapper skxdAdminUserMapper;

    @Autowired
    private SkxdAdminUserRoleMapper skxdAdminUserRoleMapper;

    @Autowired
    private SkxdAdminModuleMapper skxdAdminModuleMapper;

    @Autowired
    private SkxdAdminRoleMapper skxdAdminRoleMapper;

    @Autowired
    private SkxdAdminRoleModuleMapper skxdAdminRoleModuleMapper;

    /**
     * 为当前登录的Subject授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();
        List<SkxdAdminModule> skxdAdminModuleList = new ArrayList<SkxdAdminModule>();
        SkxdAdminRole skxdAdminRole = null;
        //从数据库中获取当前登录用户的详细信息
        Subject currentUser = SecurityUtils.getSubject();
        SkxdAdminUser user = null;
        if (null != currentUser) {
            user = (SkxdAdminUser) currentUser.getSession().getAttribute("adminUser");
        }
        if (null != user) {
            try {
                //实体类User中包含有用户角色的实体类信息
                //获取当前登录用户的角色
                SkxdAdminUserRoleExample SkxdAdminUserRoleExample = new SkxdAdminUserRoleExample();
                SkxdAdminUserRoleExample.createCriteria().andUserIdEqualTo(user.getId());
                List<SkxdAdminUserRole> skxdAdminUserRoleList = skxdAdminUserRoleMapper.selectByExample(SkxdAdminUserRoleExample);
                if (EmptyUtils.isNotEmpty(skxdAdminUserRoleList)) {
                    skxdAdminRole = skxdAdminRoleMapper.selectByPrimaryKey(skxdAdminUserRoleList.get(0).getRoleId());
                    roleList.add(skxdAdminRole.getRoleName());
                    SkxdAdminRoleModuleExample skxdAdminRoleModuleExample = new SkxdAdminRoleModuleExample();
                    skxdAdminRoleModuleExample.createCriteria().andRoleIdEqualTo(skxdAdminRole.getId());
                    List<SkxdAdminRoleModule> skxdAdminRoleModuleList = skxdAdminRoleModuleMapper.selectByExample(skxdAdminRoleModuleExample);
                    List<String> moduleIds = new ArrayList<String>();
                    SkxdAdminModuleExample skxdAdminModuleExample = new SkxdAdminModuleExample();
                    if (EmptyUtils.isNotEmpty(skxdAdminRoleModuleList)) {
                        for (SkxdAdminRoleModule skxdAdminRoleModule : skxdAdminRoleModuleList) {
                            moduleIds.add(skxdAdminRoleModule.getModuleId());
                        }
                    }
                    skxdAdminModuleExample.createCriteria().andIdIn(moduleIds).andLevelEqualTo(2);
                    skxdAdminModuleList = skxdAdminModuleMapper.selectByExample(skxdAdminModuleExample);
                }
                //根据当前角色查询权限模块
                if (EmptyUtils.isNotEmpty(skxdAdminModuleList)) {
                    for (SkxdAdminModule skxdAdminModule : skxdAdminModuleList) {
                        permissionList.add(skxdAdminModule.getValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new AuthorizationException();
        }
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);
        simpleAuthorInfo.addStringPermissions(permissionList);
        return simpleAuthorInfo;
    }

    /**
     * 验证当前登录的Subject
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        SkxdAdminUser skxdAdminUser = null;
        SkxdAdminRole skxdAdminRole = null;
        if (EmptyUtils.isNotEmpty(authcToken)) {
            SkxdAdminUserExample skxdAdminUserExample = new SkxdAdminUserExample();
            skxdAdminUserExample.createCriteria().andNameEqualTo(token.getUsername());
            List<SkxdAdminUser> skxdAdminUserList = skxdAdminUserMapper.selectByExample(skxdAdminUserExample);
            if (EmptyUtils.isNotEmpty(skxdAdminUserList)) {
                skxdAdminUser = skxdAdminUserList.get(0);
                SkxdAdminUserRoleExample skxdAdminUserRoleExample = new SkxdAdminUserRoleExample();
                skxdAdminUserRoleExample.createCriteria().andUserIdEqualTo(skxdAdminUser.getId());
                List<SkxdAdminUserRole> skxdAdminUserRoleList = skxdAdminUserRoleMapper.selectByExample(skxdAdminUserRoleExample);
                if (EmptyUtils.isNotEmpty(skxdAdminUserRoleList)) {
                    skxdAdminRole = skxdAdminRoleMapper.selectByPrimaryKey(skxdAdminUserRoleList.get(0).getRoleId());
                }
                setSession("adminUser", skxdAdminUser);
                setSession("role", skxdAdminRole);
                return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), "11");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}