package com.skxd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skxd.dao.SkxdTemplateInputMapper;
import com.skxd.model.SkxdTemplateInputExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skxd.dao.SkxdTemplateStepMapper;
import com.skxd.model.SkxdTemplateStep;
import com.skxd.model.SkxdTemplateStepExample;
import com.skxd.service.ISkxdAdminStepService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.ProjectCache;
import com.skxd.vo.SkxdTemplateStepVo;
import com.zxs.busidao.GenericDAOImpl;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

@Service
public class SkxdAdminStepService implements ISkxdAdminStepService {

    @Autowired
    private SkxdTemplateStepMapper stepMapper;

    @Autowired
    private SelectService<SkxdTemplateStep> skxdTemplateStep;
    
    @Autowired
	private GenericDAOImpl genericDAO;

    @Autowired
    private SkxdTemplateInputMapper skxdTemplateInputMapper;

    @Override
    public Page<SkxdTemplateStep> queryPage(Map params, String projectId) {
        int page = 0;
        if (EmptyUtils.isNotEmpty(params.get("page"))) {
            page = Integer.parseInt(params.get("page").toString());
        }
        params.put("page", page);
        params.put("projectId", projectId);
        String countSqlId = "TemplateStep.queryPageCount";
        String listSqlId = "TemplateStep.queryPage";
        Page<SkxdTemplateStep> result =  skxdTemplateStep.getPage(countSqlId, listSqlId, params);
        
        return result;
    }
    
    public SkxdTemplateStep getLastRecord( String projectId) {
      
        SkxdTemplateStepExample example = new SkxdTemplateStepExample();
        example.createCriteria().andProjectIdEqualTo(projectId);
        example.setOrderByClause("sort desc");
        List<SkxdTemplateStep> list = stepMapper.selectByExample(example);
        if(list == null || list.isEmpty() ) {
        	return null;
        }
        return list.get(0);
    }
    
    @Transactional
    public int delete(String ids) {
    	
//    	SkxdTemplateStep step =  this.findById(id);
//    	String projectId =  step.getProjectId();
//    	
//		 SkxdTemplateStepExample example = new SkxdTemplateStepExample();
//	     example.createCriteria().andProjectIdEqualTo(projectId).andSortGreaterThan(step.getSort());
//	     example.setOrderByClause("sort desc");
//	     List<SkxdTemplateStep> stepList = stepMapper.selectByExample(example);
//    	
//	     for(SkxdTemplateStep s:stepList) {
//	    	 s.setSort((s.getSort()-1));
//	    	 stepMapper.updateByPrimaryKeySelective(s);
//	     }
		 List<String> idsList=new ArrayList<String>();
		 String idsArray[]=ids.split(",");
	     for(int i=0;i<idsArray.length;i++){
	         idsList.add(idsArray[i]);
	     }

        SkxdTemplateInputExample skxdTemplateInputExample=new SkxdTemplateInputExample();
        skxdTemplateInputExample.createCriteria().andStepIdIn(idsList);
        skxdTemplateInputMapper.deleteByExample(skxdTemplateInputExample);

		 SkxdTemplateStepExample example = new SkxdTemplateStepExample();
		 example.createCriteria().andIdIn(idsList);
		 return stepMapper.deleteByExample(example);
	}

    @Override
    public SkxdTemplateStep findById(String id) {
        return stepMapper.selectByPrimaryKey(id);
    }
    
  

    @Override
    public int saveOrUpdate(SkxdTemplateStep step) {
        int result = 0;
    	if (EmptyUtils.isEmpty(step.getId())) {
        	result = save(step);
        } else {
        	result = stepMapper.updateByPrimaryKeySelective(step);
        }
        return result;
    }
    
    private int save(SkxdTemplateStep step) {
  	  SkxdTemplateStep lastRecord =   getLastRecord(step.getProjectId());
  	  if(lastRecord == null) {
  		  step.setSort(0);
  	  }else {
  		  step.setSort(lastRecord.getSort()+1);
  	  }
  	  step.setId(StringUtils.randomUUID());
  	  step.setCreatedDate(new Date());
  	  return stepMapper.insert(step);
     }
    
    private SkxdTemplateStep findByProjectAndSort(String projectId, Integer sort) {
    	  SkxdTemplateStepExample example = new SkxdTemplateStepExample();
    	  example.createCriteria().andProjectIdEqualTo(projectId).andSortEqualTo(sort);
          List<SkxdTemplateStep> list = stepMapper.selectByExample(example);
          return list.get(0);
    }
    
    @Override
    public int upMove(String id) {
    	SkxdTemplateStep currentStep  =  this.findById(id);
//    	int currentStepSort =  currentStep.getSort();
//    	currentStepSort--;
//    	if(currentStepSort <0) {
//    		return 0;
//    	}
    	
    	SkxdTemplateStep originalStep = findPreStepBySort(currentStep.getProjectId(), currentStep.getSort());
    	
System.out.println("currentStep===========:"+currentStep.getSort());
    	
    	if(null == originalStep) return 0;
System.out.println("originalStep===========:"+originalStep.getSort());
    	int tempSort = 0;
    	tempSort = currentStep.getSort();
    	currentStep.setSort(originalStep.getSort());
    	originalStep.setSort(tempSort);
    	stepMapper.updateByPrimaryKeySelective(currentStep);
    	int r = stepMapper.updateByPrimaryKeySelective(originalStep);
    	return r;
    }

    @Override
    public List<SkxdTemplateStep> querySkxdTemplateStepListByProject(String project) {
        SkxdTemplateStepExample skxdTemplateStepExample = new SkxdTemplateStepExample();
        skxdTemplateStepExample.setOrderByClause(" sort asc ");
        skxdTemplateStepExample.createCriteria().andProjectIdEqualTo(project);
        return stepMapper.selectByExample(skxdTemplateStepExample);
    }

    public List<SkxdTemplateStepVo> querySkxdTemplateStepListByProjectCache(String project){
        List<SkxdTemplateStep> skxdTemplateStepList = null;
        List<SkxdTemplateStepVo> skxdTemplateStepVoList = new ArrayList<SkxdTemplateStepVo>();
        if (EmptyUtils.isNotEmpty(ProjectCache.projectSteps.get(project))) {
            skxdTemplateStepList = ProjectCache.projectSteps.get(project);
        } else {
            skxdTemplateStepList = querySkxdTemplateStepListByProject(project);
            //ProjectCache.projectSteps.put(project,skxdTemplateStepList);
        }
        if(EmptyUtils.isNotEmpty(skxdTemplateStepList)){
            for(SkxdTemplateStep skxdTemplateStep:skxdTemplateStepList){
                SkxdTemplateStepVo skxdTemplateStepVo=new SkxdTemplateStepVo();
                BeanUtils.copyProperties(skxdTemplateStep,skxdTemplateStepVo);
                skxdTemplateStepVoList.add(skxdTemplateStepVo);
            }
        }
        return skxdTemplateStepVoList;
    }
    
    
    public SkxdTemplateStep findPreStepBySort(String projectId, Integer sort) {
		Map params=new HashMap();
		params.put("projectId",projectId);
		params.put("sort",sort);
		List<SkxdTemplateStep> list=genericDAO.list("TemplateStep.findPreStepBySort", params);
		if(EmptyUtils.isNotEmpty(list)){
			return  list.get(0);
		}else{
			return  null;
		}
	}
}
