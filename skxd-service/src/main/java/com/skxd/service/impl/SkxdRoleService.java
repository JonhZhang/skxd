package com.skxd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skxd.dao.SkxdRoleMapper;
import com.skxd.model.SkxdRole;
import com.skxd.model.SkxdRoleExample;
import com.skxd.service.ISkxdRoleService;

@Service
public class SkxdRoleService implements ISkxdRoleService {
	
	
	@Autowired
	private SkxdRoleMapper skxdRoleMapper;
	
	@Override
	public List<SkxdRole> findAll() {
		return skxdRoleMapper.selectByExample(null);
	}

	public SkxdRole findById(String roleId) {
		SkxdRoleExample example = new SkxdRoleExample();
		example.createCriteria().andIdEqualTo(roleId);
		return skxdRoleMapper.selectByExample(example).get(0);
	}

}
