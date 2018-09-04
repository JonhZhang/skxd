package com.skxd.service;
import com.skxd.model.SkxdAdminRole;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminRoleExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminRoleService {

    public int saveOrUpdateSkxdAdminRole(SkxdAdminRole obj)throws Exception;

    public SkxdAdminRole querySkxdAdminRoleById(String id)throws Exception;

    public int removeSkxdAdminRoleByIds(String ids)throws Exception;

    public List<SkxdAdminRole> querySkxdAdminRoleList(SkxdAdminRoleExample example)throws Exception;

    public Page<SkxdAdminRole> querySkxdAdminRolePage(Map params)throws Exception;

    public SkxdAdminRole queryYmsjRoleByUserId(String userId)throws Exception;
}
