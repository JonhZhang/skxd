package com.skxd.service;
import com.skxd.model.SkxdAdminUserRole;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminUserRoleExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminUserRoleService {

    public int saveOrUpdateSkxdAdminUserRole(SkxdAdminUserRole obj)throws Exception;

    public SkxdAdminUserRole querySkxdAdminUserRoleById(String id)throws Exception;

    public int removeSkxdAdminUserRoleByIds(String ids)throws Exception;

    public List<SkxdAdminUserRole> querySkxdAdminUserRoleList(SkxdAdminUserRoleExample example)throws Exception;

    public Page<SkxdAdminUserRole> querySkxdAdminUserRolePage(Map params)throws Exception;
}
