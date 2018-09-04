package com.skxd.service;
import com.skxd.model.SkxdDepartment;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;
/**
 * Created by shang-pc on 2015/11/8.
 */
public interface ISkxdDepartmentService {
    
    public Page<SkxdDepartment> queryDepartmentPage(Map params)throws Exception;

    public int removeDepartmentByIds(String ids)throws Exception;

    public SkxdDepartment queryDepartmentById(String id)throws Exception;

    public int saveOrUpdateDepartment(SkxdDepartment skxdDepartment)throws Exception;

    public List<SkxdDepartment> queryDepartmentAll()throws Exception;

    public String queryDepartmentIdByName(String name,int i);
}
