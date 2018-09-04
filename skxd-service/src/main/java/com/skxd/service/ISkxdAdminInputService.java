package com.skxd.service;

import com.skxd.model.SkxdTemplateInput;
import com.skxd.model.SkxdTemplateInputExample;
import com.skxd.vo.SkxdTemplateInputVo;
import com.skxd.vo.SkxdTemplateStepVo;
import com.zxs.common.Page;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * <p/>
 * Created by zzshang on 2015/11/10.
 */
public interface ISkxdAdminInputService {

    public List<SkxdTemplateInput> querySkxdTemplateInputListByStep(String step);

    public List<SkxdTemplateStepVo> querySkxdTemplateInputVoListByStepList(List<SkxdTemplateStepVo> SkxdTemplateStepVoList)throws Exception;

    public List<SkxdTemplateStepVo> querySkxdTemplateInputAnswerListByStepList(List<SkxdTemplateStepVo> skxdTemplateStepVoList, String answerId) throws Exception;
    
    Page<SkxdTemplateInput> queryPage(Map params, String projectId);
    
    int saveOrUpdate(SkxdTemplateInput templateInput);

    public SkxdTemplateInput findPreInputBySort(String stepId, Integer sort);

    public List<SkxdTemplateInput> querySkxdTemplateInputList(SkxdTemplateInputExample skxdTemplateInputExample);

    public int delete(String ids);

    public SkxdTemplateInput findById(String id);

    public void upMove(String id);
}
