package com.skxd.service.impl;

import com.skxd.dao.SkxdAdminDictionaryValueMapper;
import com.skxd.dao.SkxdTemplateInputMapper;
import com.skxd.model.*;
import com.skxd.service.ISkxdAdminInputService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.ProjectCache;
import com.skxd.vo.SkxdTemplateInputVo;
import com.skxd.vo.SkxdTemplateStepVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 * <p>
 * Created by zzshang on 2015/11/10.
 */
@Service
public class SkxdAdminInputService implements ISkxdAdminInputService {

    @Autowired
    private SkxdTemplateInputMapper skxdTemplateInputMapper;

    @Autowired
    private SelectService<SkxdTemplateInput> skxdTemplateInputSelect;

    @Autowired
    private GenericDAOImpl genericDAO;

    @Autowired
    private SkxdAdminDictionaryValueMapper skxdAdminDictionaryValueMapper;

    @Override
    public List<SkxdTemplateInput> querySkxdTemplateInputListByStep(String step) {
        SkxdTemplateInputExample skxdTemplateInputExample = new SkxdTemplateInputExample();
        skxdTemplateInputExample.createCriteria().andStepIdEqualTo(step);
        skxdTemplateInputExample.setOrderByClause(" sort asc ");
        List<SkxdTemplateInput> skxdTemplateInputList = skxdTemplateInputMapper.selectByExample(skxdTemplateInputExample);
        return skxdTemplateInputList;
    }

    /**
     * @param skxdTemplateStepVoList
     * @return
     * @throws Exception
     */
    public List<SkxdTemplateStepVo> querySkxdTemplateInputVoListByStepList(List<SkxdTemplateStepVo> skxdTemplateStepVoList) throws Exception {
        if (EmptyUtils.isNotEmpty(skxdTemplateStepVoList)) {
            for (SkxdTemplateStepVo stepVo : skxdTemplateStepVoList) {
                List<SkxdTemplateInputVo> skxdTemplateInputVoList = new ArrayList<SkxdTemplateInputVo>();
                List<SkxdTemplateInput> skxdTemplateInputList = new ArrayList<SkxdTemplateInput>();
                if (EmptyUtils.isNotEmpty(ProjectCache.stepInputs.get(stepVo.getId()))) {
                    skxdTemplateInputList = ProjectCache.stepInputs.get(stepVo.getId());
                } else {
                    skxdTemplateInputList = querySkxdTemplateInputListByStep(stepVo.getId());
                    //ProjectCache.stepInputs.put(stepVo.getId(),skxdTemplateInputList);
                }
                if (EmptyUtils.isNotEmpty(skxdTemplateInputList)) {
                    for (SkxdTemplateInput skxdTemplateInput : skxdTemplateInputList) {
                        SkxdTemplateInputVo skxdTemplateInputVo = new SkxdTemplateInputVo();
                        BeanUtils.copyProperties(skxdTemplateInput, skxdTemplateInputVo);
                        skxdTemplateInputVoList.add(skxdTemplateInputVo);
                    }
                }
                stepVo.setSkxdTemplateInputVoList(skxdTemplateInputVoList);
            }
        }
        return skxdTemplateStepVoList;
    }

    /**
     * @param skxdTemplateStepVoList
     * @return
     * @throws Exception
     */
    public List<SkxdTemplateStepVo> querySkxdTemplateInputAnswerListByStepList(
            List<SkxdTemplateStepVo> skxdTemplateStepVoList, String answerId)
            throws Exception {
        if (EmptyUtils.isNotEmpty(skxdTemplateStepVoList)) {
            for (SkxdTemplateStepVo skxdTemplateStepVo : skxdTemplateStepVoList) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("stepId", skxdTemplateStepVo.getId());
                params.put("answerId", answerId);
                List<SkxdTemplateInputVo> skxdTemplateInputVoList = genericDAO.list("ANSWERVALUE.selectSkxdAnswerValues", params);
                skxdTemplateStepVo.setSkxdTemplateInputVoList(skxdTemplateInputVoList);
            }
        }
        return skxdTemplateStepVoList;
    }

    public Page<SkxdTemplateInput> queryPage(Map params, String projectId) {
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        params.put("projectId", projectId);
        String countSqlId = "TemplateInput.queryPageCount";
        String listSqlId = "TemplateInput.queryPage";
        Page<SkxdTemplateInput> result = skxdTemplateInputSelect.getPage(countSqlId, listSqlId, params);
        return result;
    }

    public SkxdTemplateInput findById(String id) {
        return skxdTemplateInputMapper.selectByPrimaryKey(id);
    }

    public int delete(String ids) {
        int flag = 0;
        List<String> idsList = new ArrayList<String>();
        String idsArray[] = ids.split(",");
        for (int i = 0; i < idsArray.length; i++) {
            idsList.add(idsArray[i]);
        }
        SkxdTemplateInputExample example = new SkxdTemplateInputExample();
        example.createCriteria().andIdIn(idsList);
        flag = skxdTemplateInputMapper.deleteByExample(example);
        return flag;
    }

    @Override
    public int saveOrUpdate(SkxdTemplateInput templateInput) {
        int flag = 0;
        if (EmptyUtils.isNotEmpty(templateInput.getId())) {
            templateInput.setUpdatedDate(new Date());
            flag = skxdTemplateInputMapper
                    .updateByPrimaryKeySelective(templateInput);
        } else {
            save(templateInput);
        }

        return flag;
    }

    public void upMove(String id) {
        SkxdTemplateInput currentInput = skxdTemplateInputMapper.selectByPrimaryKey(id);
        SkxdTemplateInput originalInput = findPreInputBySort(currentInput.getStepId(), currentInput.getSort());
        if (null == originalInput) return;

        System.out.println("currentStep===========:" + currentInput.getSort());

        System.out.println("originalStep===========:" + originalInput.getSort());

        int tempSort = 0;
        tempSort = currentInput.getSort();
        currentInput.setSort(originalInput.getSort());
        originalInput.setSort(tempSort);
        skxdTemplateInputMapper.updateByPrimaryKeySelective(currentInput);
        skxdTemplateInputMapper.updateByPrimaryKeySelective(originalInput);
    }

    private int save(SkxdTemplateInput input) {
        SkxdTemplateInput lastRecord = getLastRecord(input.getStepId());
        if (lastRecord == null) {
            input.setSort(0);
        } else {
            input.setSort(lastRecord.getSort() + 1);
        }
        input.setId(StringUtils.randomUUID());
        input.setCreatedDate(new Date());
        return skxdTemplateInputMapper.insert(input);
    }

    public SkxdTemplateInput getLastRecord(String stepId) {

        SkxdTemplateInputExample example = new SkxdTemplateInputExample();
        example.createCriteria().andStepIdEqualTo(stepId);
        example.setOrderByClause("sort desc");
        List<SkxdTemplateInput> list = skxdTemplateInputMapper.selectByExample(example);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private SkxdTemplateInput findByProjectAndSort(String projectId, Integer sort) {
        SkxdTemplateInputExample example = new SkxdTemplateInputExample();
        example.createCriteria().andProjectIdEqualTo(projectId).andSortEqualTo(sort);
        List<SkxdTemplateInput> list = skxdTemplateInputMapper.selectByExample(example);
        return list.get(0);
    }

    public SkxdTemplateInput findPreInputBySort(String stepId, Integer sort) {
        Map params = new HashMap();
        params.put("stepId", stepId);
        params.put("sort", sort);
        List<SkxdTemplateInput> skxdTemplateInputList = genericDAO.list("TemplateInput.findPreInputBySort", params);
        if (EmptyUtils.isNotEmpty(skxdTemplateInputList)) {
            return skxdTemplateInputList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<SkxdTemplateInput> querySkxdTemplateInputList(SkxdTemplateInputExample skxdTemplateInputExample) {
       return skxdTemplateInputMapper.selectByExample(skxdTemplateInputExample);
    }

}
