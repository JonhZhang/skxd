package com.skxd.service.impl;
import com.skxd.dao.SkxdAdminUserMapper;
import com.skxd.model.SkxdAdminUser;
import com.skxd.model.SkxdAdminUserExample;
import com.skxd.service.ISkxdAdminUserService;
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
public class SkxdAdminUserServiceImpl implements ISkxdAdminUserService {

    @Autowired
    private SkxdAdminUserMapper skxdAdminUserMapper;

    @Autowired
    private SelectService<SkxdAdminUser> selectService;

    public int saveOrUpdateSkxdAdminUser(SkxdAdminUser skxdAdminUser) throws Exception{
        int flag=0;
        if(EmptyUtils.isNotEmpty(skxdAdminUser.getId())){
            skxdAdminUser.setUpdatedDate(new Date());
            flag=skxdAdminUserMapper.updateByPrimaryKeySelective(skxdAdminUser);
        }else{
            skxdAdminUser.setId(StringUtils.randomUUID());
            skxdAdminUser.setCreatedDate(new Date());
            flag=skxdAdminUserMapper.insert(skxdAdminUser);
        }
        return flag;
    }

    public SkxdAdminUser querySkxdAdminUserById(String id) throws Exception{
        return skxdAdminUserMapper.selectByPrimaryKey(id);
    }

    public int removeSkxdAdminUserByIds(String ids)throws Exception{
        SkxdAdminUserExample skxdAdminUserExample=new SkxdAdminUserExample();
        List<String> idsList=new ArrayList<String>();
        String idsArray[]=ids.split(",");
        for(int i=0;i<idsArray.length;i++){
            idsList.add(idsArray[i]);
        }
        skxdAdminUserExample.createCriteria().andIdIn(idsList);
        int flag=skxdAdminUserMapper.deleteByExample(skxdAdminUserExample);
        return flag;
    }

    public List<SkxdAdminUser> querySkxdAdminUserList(SkxdAdminUserExample example)throws Exception{
        return skxdAdminUserMapper.selectByExample(example);
    }

    public Page<SkxdAdminUser> querySkxdAdminUserPage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "SkxdAdminUser.getSkxdAdminUserCount";
        String listSqlId = "SkxdAdminUser.getSkxdAdminUserPage";
        Page<SkxdAdminUser> result = selectService.getPage(countSqlId, listSqlId, params);
        return result;
    }

    @Override
    public SkxdAdminUser validateUser(String userName, String password) throws Exception{
        SkxdAdminUserExample skxdAdminUserExample=new SkxdAdminUserExample();
        skxdAdminUserExample.createCriteria().andNameEqualTo(userName).andPasswordEqualTo(password);
        List<SkxdAdminUser> skxdAdminUserList=skxdAdminUserMapper.selectByExample(skxdAdminUserExample);
        if(EmptyUtils.isNotEmpty(skxdAdminUserList)){
            return skxdAdminUserList.get(0);
        }
        return null;
    }
}
