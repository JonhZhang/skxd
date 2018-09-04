package com.skxd.service.impl;

import com.skxd.dao.SkxdAdminModuleMapper;
import com.skxd.dao.SkxdAdminRoleModuleMapper;
import com.skxd.model.SkxdAdminModule;
import com.skxd.model.SkxdAdminModuleExample;
import com.skxd.model.SkxdAdminRoleModule;
import com.skxd.model.SkxdAdminRoleModuleExample;
import com.skxd.service.ISkxdAdminModuleService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.NodeVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Constant;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p></p>
 * <p>
 * Created by zzshang on 2015/10/29.
 */
@Service
public class SkxdAdminModuleService implements ISkxdAdminModuleService {

    @Autowired
    private SkxdAdminModuleMapper skxdAdminModuleMapper;

    @Autowired
    private SelectService<SkxdAdminModule> selectService;

    @Autowired
    private GenericDAOImpl genericDAO;

    @Autowired
    private SkxdAdminRoleModuleMapper skxdAdminRoleModuleMapper;

    @Override
    public List<SkxdAdminModule> querySkxdAdminModuleList(SkxdAdminModuleExample SkxdAdminModuleExample)throws Exception {
        return skxdAdminModuleMapper.selectByExample(SkxdAdminModuleExample);
    }

    @Override
    public List<SkxdAdminModule> querySkxdAdminModuleByParent(String parent)throws Exception {
        SkxdAdminModuleExample skxdAdminModuleExample = new SkxdAdminModuleExample();
        skxdAdminModuleExample.setOrderByClause("sort asc");
        skxdAdminModuleExample.createCriteria().andParentEqualTo(parent);
        return skxdAdminModuleMapper.selectByExample(skxdAdminModuleExample);
    }

    @Override
    public List<SkxdAdminModule> querySkxdAdminModuleByLevel(int level) throws Exception{
        SkxdAdminModuleExample skxdAdminModuleExample = new SkxdAdminModuleExample();
        skxdAdminModuleExample.setOrderByClause("sort asc");
        skxdAdminModuleExample.createCriteria().andLevelEqualTo(level);
        return skxdAdminModuleMapper.selectByExample(skxdAdminModuleExample);
    }

    @Override
    public Page<SkxdAdminModule> querySkxdAdminModulePage(Map params)throws Exception{
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        String countSqlId = "MODULE.getSkxdAdminModuleCount";
        String listSqlId = "MODULE.getSkxdAdminModulePage";
        return selectService.getPage(countSqlId, listSqlId, params);
    }

    @Override
    public int saveOrUpdateModule(SkxdAdminModule SkxdAdminModule)throws Exception {
        if (EmptyUtils.isEmpty(SkxdAdminModule.getId())) {
            SkxdAdminModule.setId(StringUtils.randomUUID());
            SkxdAdminModule.setCreatedTime(new Date());
            SkxdAdminModule.setIsDelete(Constant.DeleteStatus.NO_DELETE);
            return skxdAdminModuleMapper.insert(SkxdAdminModule);
        } else {
            SkxdAdminModule.setUpdatedTime(new Date());
            return skxdAdminModuleMapper.updateByPrimaryKeySelective(SkxdAdminModule);
        }
    }

    @Override
    public int removeByIds(String ids)throws Exception {
        SkxdAdminModuleExample skxdAdminModuleExample = new SkxdAdminModuleExample();
        List<String> idsList = new ArrayList<String>();
        String idsArray[] = ids.split(",");
        for (int i = 0; i < idsArray.length; i++) {
            idsList.add(idsArray[i]);
        }
        skxdAdminModuleExample.createCriteria().andIdIn(idsList);
        int flag = skxdAdminModuleMapper.deleteByExample(skxdAdminModuleExample);
        return flag;
    }

    @Override
    public SkxdAdminModule querySkxdAdminModuleById(String id) throws Exception{
        return skxdAdminModuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int bindModule(List<SkxdAdminRoleModule> skxdAdminRoleModuleList, String roleId)throws Exception{
        Map params=new HashMap();
        //删除原有权限
        SkxdAdminRoleModuleExample skxdAdminRoleModuleExample=new SkxdAdminRoleModuleExample();
        skxdAdminRoleModuleExample.createCriteria().andRoleIdEqualTo(roleId);
        skxdAdminRoleModuleMapper.deleteByExample(skxdAdminRoleModuleExample);
        //赋值新权限
        params.put("skxdAdminRoleModuleList",skxdAdminRoleModuleList);
        return genericDAO.insert("SkxdAdminRoleModule.bindModule",params);
    }

    @Override
    public List<NodeVo> queryTreeNode(String roleId) throws Exception {
        Map params=new HashMap();
        params.put("roleId",roleId);
        return genericDAO.list("SkxdAdminRoleModule.queryTreeNode", params);
    }
}
