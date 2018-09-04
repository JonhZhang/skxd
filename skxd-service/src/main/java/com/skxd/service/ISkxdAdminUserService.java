package com.skxd.service;
import com.skxd.model.SkxdAdminUser;
import java.util.List;
import java.util.Map;
import com.skxd.model.SkxdAdminUserExample;
import java.util.List;
import java.util.Map;
import com.zxs.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ISkxdAdminUserService {

    public int saveOrUpdateSkxdAdminUser(SkxdAdminUser obj)throws Exception;

    public SkxdAdminUser querySkxdAdminUserById(String id)throws Exception;

    public int removeSkxdAdminUserByIds(String ids)throws Exception;

    public List<SkxdAdminUser> querySkxdAdminUserList(SkxdAdminUserExample example)throws Exception;

    public Page<SkxdAdminUser> querySkxdAdminUserPage(Map params)throws Exception;

    public SkxdAdminUser validateUser(String userName,String password)throws Exception;
}
