package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminUserRoleMapper;
import com.skxd.model.SkxdAdminUserRole;
import com.skxd.model.SkxdAdminUserRoleExample;
import com.skxd.service.ISkxdAdminUserRoleService;
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
public class SkxdAdminUserRoleServiceImpl implements ISkxdAdminUserRoleService {

    @Autowired
    private SkxdAdminUserRoleMapper skxdAdminUserRoleMapper;

    @Autowired
    private SelectService<SkxdAdminUserRole> selectService;

    public int saveOrUpdateSkxdAdminUserRole(SkxdAdminUserRole skxdAdminUserRole) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminUserRole.getId())){
            skxdAdminUserRole.setUpdatedDate(new Date());
            flag=skxdAdminUserRoleMapper.updateByPrimaryKeySelective(skxdAdminUserRole);
        }else{
            skxdAdminUserRole.setId(StringUtils.randomUUID());
            skxdAdminUserRole.setCreatedDate(new Date());
            flag=skxdAdminUserRoleMapper.insert(skxdAdminUserRole);
        }
        return flag;
    }

    public SkxdAdminUserRole querySkxdAdminUserRoleById(String id) throws Exception{
        return skxdAdminUserRoleMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminUserRoleByIds(String ids)throws Exception{
        SkxdAdminUserRoleExample skxdAdminUserRoleExample=new SkxdAdminUserRoleExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminUserRoleExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminUserRoleMapper.deleteByExample(skxdAdminUserRoleExample);
        return flag;
    }

    public List<SkxdAdminUserRole> querySkxdAdminUserRoleList(SkxdAdminUserRoleExample example)throws Exception{
        return skxdAdminUserRoleMapper.selectByExample(example);
    }

    public Page<SkxdAdminUserRole> querySkxdAdminUserRolePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminUserRole.getSkxdAdminUserRoleCount";
        String listSqlId = "SkxdAdminUserRole.getSkxdAdminUserRolePage";
        Page<SkxdAdminUserRole> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
