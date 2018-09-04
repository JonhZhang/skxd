package com.skxd.service;

import java.util.List;
import java.util.Map;

import com.skxd.model.SkxdTemplateStep;
import com.skxd.vo.SkxdTemplateStepVo;
import com.zxs.common.Page;

/**
 * <p>账户管理service</p>
 * <p/>
 * Created by zzshang on 2015/8/19.
 */
public interface ISkxdAdminStepService {

    Page<SkxdTemplateStep> queryPage(Map params, String projectId);

    SkxdTemplateStep findById(String id);

    int saveOrUpdate(SkxdTemplateStep step);

    public List<SkxdTemplateStep> querySkxdTemplateStepListByProject(String project);

    public List<SkxdTemplateStepVo> querySkxdTemplateStepListByProjectCache(String project);
    
    SkxdTemplateStep getLastRecord( String projectId);
    /**
     * 将排序向上移动
     * @param id
     */
    int upMove(String id);
    /**
     * 根据id删除输入
     * @param ids
     * @return
     */
    public int delete(String ids);
}
