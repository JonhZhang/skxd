package com.skxd.service;
import com.skxd.model.SkxdAdminRoleModule;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminRoleModuleExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminRoleModuleService {

    public int saveOrUpdateSkxdAdminRoleModule(SkxdAdminRoleModule obj)throws Exception;

    public SkxdAdminRoleModule querySkxdAdminRoleModuleById(String id)throws Exception;

    public int removeSkxdAdminRoleModuleByIds(String ids)throws Exception;

    public List<SkxdAdminRoleModule> querySkxdAdminRoleModuleList(SkxdAdminRoleModuleExample example)throws Exception;

    public Page<SkxdAdminRoleModule> querySkxdAdminRoleModulePage(Map params)throws Exception;
}
