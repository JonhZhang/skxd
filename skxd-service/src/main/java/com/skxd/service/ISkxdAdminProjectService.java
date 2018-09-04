package com.skxd.service;
import java.util.List;
import java.util.Map;

import com.skxd.model.SkxdTemplateProject;
import com.zxs.common.Page;

/**
 * <p>账户管理service</p>
 * <p/>
 * Created by zzshang on 2015/8/19.
 */
public interface ISkxdAdminProjectService {

	Page<SkxdTemplateProject> queryProjectPage(Map params);

	SkxdTemplateProject findById(String id);

	int saveOrUpdate(SkxdTemplateProject project);

	int delete(String ids);

	List<SkxdTemplateProject> querySkxdTemplateProjectList();
}
