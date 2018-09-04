package com.skxd.service;
import com.skxd.model.SkxdAdminModule;
import com.skxd.model.SkxdAdminModuleExample;
import com.skxd.model.SkxdAdminRoleModule;
import com.skxd.vo.NodeVo;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/10/29.
 */
public interface ISkxdAdminModuleService {

    public List<SkxdAdminModule> querySkxdAdminModuleList(SkxdAdminModuleExample skxdAdminModuleExample)throws Exception;

    public List<SkxdAdminModule> querySkxdAdminModuleByParent(String parent)throws Exception;

    public List<SkxdAdminModule> querySkxdAdminModuleByLevel(int level)throws Exception;

    public Page<SkxdAdminModule> querySkxdAdminModulePage(Map prams)throws Exception;

    public int saveOrUpdateModule(SkxdAdminModule SkxdAdminModule)throws Exception;

    public int removeByIds(String ids)throws Exception;

    public SkxdAdminModule querySkxdAdminModuleById(String id)throws Exception;

    public int bindModule(List<SkxdAdminRoleModule> skxdAdminRoleModuleList, String roleId)throws Exception;

    public List<NodeVo> queryTreeNode(String roleId) throws Exception;
}
