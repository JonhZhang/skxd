package com.skxd.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.skxd.model.SkxdTemplateProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skxd.dao.SkxdTemplateProjectMapper;
import com.skxd.model.SkxdTemplateProject;
import com.skxd.service.ISkxdAdminProjectService;
import com.skxd.service.common.SelectService;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

@Service
public class SkxdAdminProjectService implements ISkxdAdminProjectService{
	
	@Autowired
	private SkxdTemplateProjectMapper projectMapper;
	
	@Autowired
	private SelectService<SkxdTemplateProject> skxdTemplateProject;
	
	@Override
	public Page<SkxdTemplateProject>  queryProjectPage(Map params) {
	 	int page =0;
        if(EmptyUtils.isNotEmpty(params.get("page"))){
            page =Integer.parseInt(params.get("page").toString());
        }
        params.put("page",page);
        String countSqlId = "TemplateProject.queryProjectPageCount";
        String listSqlId = "TemplateProject.queryProjectPage";
        return skxdTemplateProject.getPage(countSqlId,listSqlId,params);
	}

	@Override
	public SkxdTemplateProject findById(String id) {
		return projectMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int saveOrUpdate(SkxdTemplateProject project) {
		 int flag=0;
	        if(EmptyUtils.isNotEmpty(project.getId())){
	        	project.setUpdatedDate(new Date());
	            flag=projectMapper.updateByPrimaryKeySelective(project);
	        }else{
	        	project.setId(StringUtils.randomUUID());
	        	project.setCreatedDate(new Date());
	        	project.setUpdatedDate(new Date());
	        	//TODO 没有当前人
	        	project.setCreatedUser("");
	        	project.setUpdatedUser("");
	            flag=projectMapper.insert(project);
	        }
	        return flag;
	}

	@Override
	public int delete(String ids) {
		return 0;
	}

	@Override
	public List<SkxdTemplateProject> querySkxdTemplateProjectList() {
		SkxdTemplateProjectExample skxdTemplateProjectExample=new SkxdTemplateProjectExample();
		return projectMapper.selectByExample(skxdTemplateProjectExample);
	}

}
