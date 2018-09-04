package com.skxd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skxd.dao.SkxdUserAreaMapper;
import com.skxd.model.SkxdUserArea;
import com.skxd.model.SkxdUserAreaExample;
import com.skxd.service.ISkxdUserAreaService;
import org.springframework.stereotype.Service;

@Service
public class SkxdUserAreaService implements ISkxdUserAreaService {
    @Autowired
    private SkxdUserAreaMapper skxdUserAreaMapper;

	public  List<SkxdUserArea> selectUserArea(String userId) {
		SkxdUserAreaExample example = new SkxdUserAreaExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return skxdUserAreaMapper.selectByExample(example);
	}
}
