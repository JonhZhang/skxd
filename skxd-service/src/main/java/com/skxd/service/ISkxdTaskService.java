package com.skxd.service;

import java.util.Map;

import com.skxd.model.SkxdTask;
import com.zxs.common.Page;

public interface ISkxdTaskService {
	int saveOrUpdateSkxdTask(SkxdTask skxdTask) throws Exception;
	Page<SkxdTask> querySkxdTaskPage(Map params);
}
