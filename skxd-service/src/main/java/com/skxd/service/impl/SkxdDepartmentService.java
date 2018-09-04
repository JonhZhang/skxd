package com.skxd.service.impl;
import com.skxd.dao.SkxdDepartmentMapper;
import com.skxd.model.SkxdCustom;
import com.skxd.model.SkxdCustomExample;
import com.skxd.model.SkxdDepartment;
import com.skxd.model.SkxdDepartmentExample;
import com.skxd.service.ISkxdDepartmentService;
import com.skxd.service.common.SelectService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * Created by shang-pc on 2015/11/8.
 */
@Service
public class SkxdDepartmentService implements ISkxdDepartmentService {

    @Autowired
    private SkxdDepartmentMapper skxdDepartmentMapper;

    @Autowired
    private SelectService<SkxdDepartment> selectService;

    static Map<String,String> departMentParams;

    @Override
    public Page<SkxdDepartment> queryDepartmentPage(Map params) throws Exception{
        int page =0;
        if(EmptyUtils.isNotEmpty(params.get("page"))){
            page =Integer.parseInt(params.get("page").toString());
        }
        params.put("page",page);
        String countSqlId = "DEPARTMENT.getSkxdDepartmentCount";
        String listSqlId = "DEPARTMENT.getSkxdDepartmentPage";
        return selectService.getPage(countSqlId,listSqlId,params);
    }

    @Override
    public int removeDepartmentByIds(String ids) throws Exception {
        SkxdDepartmentExample skxdDeviceExample=new SkxdDepartmentExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdDeviceExample.createCriteria().andIdIn(idsList);
        int flag=skxdDepartmentMapper.deleteByExample(skxdDeviceExample);
        return flag;
    }

    @Override
    public SkxdDepartment queryDepartmentById(String id) throws Exception {
        return skxdDepartmentMapper.selectByPrimaryKey(id);
    }

    public List<SkxdDepartment>  queryDepartmentAll()throws Exception {
        SkxdDepartmentExample skxdDeviceExample=new SkxdDepartmentExample();
        skxdDeviceExample.createCriteria();
        return skxdDepartmentMapper.selectByExample(skxdDeviceExample);
    }

    @Override
    public int saveOrUpdateDepartment(SkxdDepartment skxdDepartment) throws Exception {
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdDepartment.getId())){
            skxdDepartment.setUpdatedDate(new Date());
            flag=skxdDepartmentMapper.updateByPrimaryKeySelective(skxdDepartment);
        }else{
            skxdDepartment.setId(StringUtils.randomUUID());
            skxdDepartment.setCreatedDate(new Date());
            flag=skxdDepartmentMapper.insert(skxdDepartment);
        }
        return flag;
    }

    public String queryDepartmentIdByName(String name,int i){
        List<SkxdDepartment> skxdDepartmentList=new ArrayList<SkxdDepartment>();
        if(EmptyUtils.isEmpty(departMentParams) || i==1){
            departMentParams=new HashMap<>();
            SkxdDepartmentExample skxdDepartmentExample = new SkxdDepartmentExample();
            skxdDepartmentList=skxdDepartmentMapper.selectByExample(skxdDepartmentExample);
            for(SkxdDepartment skxdDepartment:skxdDepartmentList){
                departMentParams.put(skxdDepartment.getDepartmentName(),skxdDepartment.getId());
            }
        }
        return departMentParams.get(name);
    }
}
