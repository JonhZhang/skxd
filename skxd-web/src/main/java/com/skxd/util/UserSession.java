package com.skxd.util;

import com.skxd.model.SkxdAdminRole;
import com.skxd.model.SkxdAdminUser;
import org.apache.shiro.SecurityUtils;

import java.io.Serializable;

/**
 * Created by shang-pc on 2015/11/29.
 */
public class UserSession implements Serializable{


    public static SkxdAdminUser getLoginSkxdAdminUser(){
        return (SkxdAdminUser) SecurityUtils.getSubject().getSession().getAttribute("adminUser");
    }

    public static SkxdAdminRole getLoginSkxdAdminRole(){
        return (SkxdAdminRole) SecurityUtils.getSubject().getSession().getAttribute("role");
    }
}
