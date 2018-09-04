package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminRoleMapper;
import com.skxd.dao.SkxdAdminUserRoleMapper;
import com.skxd.model.*;
import com.skxd.service.ISkxdAdminRoleService;
import com.skxd.service.common.SelectService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SkxdAdminRoleServiceImpl implements ISkxdAdminRoleService {

    @Autowired
    private SkxdAdminRoleMapper skxdAdminRoleMapper;

    @Autowired
    private SkxdAdminUserRoleMapper skxdAdminUserRoleMapper;

    @Autowired
    private SelectService<SkxdAdminRole> selectService;

    public int saveOrUpdateSkxdAdminRole(SkxdAdminRole skxdAdminRole) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminRole.getId())){
            skxdAdminRole.setUpdatedDate(new Date());
            flag=skxdAdminRoleMapper.updateByPrimaryKeySelective(skxdAdminRole);
        }else{
            skxdAdminRole.setId(StringUtils.randomUUID());
            skxdAdminRole.setCreatedDate(new Date());
            flag=skxdAdminRoleMapper.insert(skxdAdminRole);
        }
        return flag;
    }

    public SkxdAdminRole querySkxdAdminRoleById(String id) throws Exception{
        return skxdAdminRoleMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminRoleByIds(String ids)throws Exception{
        SkxdAdminRoleExample skxdAdminRoleExample=new SkxdAdminRoleExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminRoleExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminRoleMapper.deleteByExample(skxdAdminRoleExample);
        return flag;
    }

    public List<SkxdAdminRole> querySkxdAdminRoleList(SkxdAdminRoleExample example)throws Exception{
        return skxdAdminRoleMapper.selectByExample(example);
    }

    public Page<SkxdAdminRole> querySkxdAdminRolePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminRole.getSkxdAdminRoleCount";
        String listSqlId = "SkxdAdminRole.getSkxdAdminRolePage";
        Page<SkxdAdminRole> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public SkxdAdminRole queryYmsjRoleByUserId(String userId) throws Exception {
        SkxdAdminUserRoleExample skxdAdminUserRoleExample=new SkxdAdminUserRoleExample();
        skxdAdminUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<SkxdAdminUserRole> skxdAdminUserRoleList=skxdAdminUserRoleMapper.selectByExample(skxdAdminUserRoleExample);
        SkxdAdminUserRole skxdAdminUserRole=null;
        if(EmptyUtils.isNotEmpty(skxdAdminUserRoleList)){
            skxdAdminUserRole=skxdAdminUserRoleList.get(0);
        }
        return skxdAdminRoleMapper.selectByPrimaryKey(skxdAdminUserRole.getRoleId());
    }
}
