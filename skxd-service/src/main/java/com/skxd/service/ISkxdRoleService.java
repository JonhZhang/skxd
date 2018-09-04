package com.skxd.service;
import java.util.List;

import com.skxd.model.SkxdRole;

/**
 * <p>账户管理service</p>
 * <p/>
 * Created by zzshang on 2015/8/19.
 */
public interface ISkxdRoleService {
	List<SkxdRole> findAll() ;
	SkxdRole findById(String roleId);
}
