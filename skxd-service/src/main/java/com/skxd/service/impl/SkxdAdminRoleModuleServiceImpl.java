package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminRoleModuleMapper;
import com.skxd.model.SkxdAdminRoleModule;
import com.skxd.model.SkxdAdminRoleModuleExample;
import com.skxd.service.ISkxdAdminRoleModuleService;
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
public class SkxdAdminRoleModuleServiceImpl implements ISkxdAdminRoleModuleService {

    @Autowired
    private SkxdAdminRoleModuleMapper skxdAdminRoleModuleMapper;

    @Autowired
    private SelectService<SkxdAdminRoleModule> selectService;

    public int saveOrUpdateSkxdAdminRoleModule(SkxdAdminRoleModule skxdAdminRoleModule) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminRoleModule.getId())){
            skxdAdminRoleModule.setUpdatedDate(new Date());
            flag=skxdAdminRoleModuleMapper.updateByPrimaryKeySelective(skxdAdminRoleModule);
        }else{
            skxdAdminRoleModule.setId(StringUtils.randomUUID());
            skxdAdminRoleModule.setCreatedDate(new Date());
            flag=skxdAdminRoleModuleMapper.insert(skxdAdminRoleModule);
        }
        return flag;
    }

    public SkxdAdminRoleModule querySkxdAdminRoleModuleById(String id) throws Exception{
        return skxdAdminRoleModuleMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminRoleModuleByIds(String ids)throws Exception{
        SkxdAdminRoleModuleExample skxdAdminRoleModuleExample=new SkxdAdminRoleModuleExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminRoleModuleExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminRoleModuleMapper.deleteByExample(skxdAdminRoleModuleExample);
        return flag;
    }

    public List<SkxdAdminRoleModule> querySkxdAdminRoleModuleList(SkxdAdminRoleModuleExample example)throws Exception{
        return skxdAdminRoleModuleMapper.selectByExample(example);
    }

    public Page<SkxdAdminRoleModule> querySkxdAdminRoleModulePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminRoleModule.getSkxdAdminRoleModuleCount";
        String listSqlId = "SkxdAdminRoleModule.getSkxdAdminRoleModulePage";
        Page<SkxdAdminRoleModule> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }
}
