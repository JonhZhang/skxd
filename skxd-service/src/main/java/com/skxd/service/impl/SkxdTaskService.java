package com.skxd.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skxd.dao.SkxdTaskMapper;
import com.skxd.model.SkxdTask;
import com.skxd.model.SkxdTaskExample;
import com.skxd.service.ISkxdTaskService;
import com.skxd.service.common.SelectService;
import com.skxd.vo.SkxdUserVo;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;
import com.zxs.utils.lang.StringUtils;

@Service
public class SkxdTaskService implements ISkxdTaskService {
	 	@Autowired
	    private SkxdTaskMapper skxdTaskMapper;

	    @Autowired
	    private SelectService<SkxdTask> selectService;
	    
	    
	    public int saveOrUpdateSkxdTask(SkxdTask skxdTask) throws Exception{
	        int flag=0;
	        if(EmptyUtils.isNotEmpty(skxdTask.getId())){
	        	skxdTask.setUpdatedDate(new Date());
	            flag=skxdTaskMapper.updateByPrimaryKeySelective(skxdTask);
	        }else{
	        	skxdTask.setId(StringUtils.randomUUID());
	        	skxdTask.setCreatedDate(new Date());
	            flag=skxdTaskMapper.insert(skxdTask);
	        }
	        return flag;
	    }
	    
	    @Override
	    public Page<SkxdTask> querySkxdTaskPage(Map params){
	        int page =0;
	        if(EmptyUtils.isNotEmpty(params.get("page"))){
	            page =Integer.parseInt(params.get("page").toString());
	        }
	        params.put("page",page);
	        String countSqlId = "TASK.getSkxdTaskCount";
	        String listSqlId = "TASK.getSkxdTaskPage";
	        return selectService.getPage(countSqlId,listSqlId,params);
	    }
}
