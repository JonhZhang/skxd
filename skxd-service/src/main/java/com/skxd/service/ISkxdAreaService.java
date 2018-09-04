package com.skxd.service;

import java.util.List;
import java.util.Map;

import com.skxd.model.SkxdArea;
import com.skxd.model.SkxdAreaExample;
import com.skxd.model.SkxdUserPower;
import com.zxs.common.Page;
import com.zxs.utils.lang.EmptyUtils;

public interface ISkxdAreaService {

	 List<SkxdArea>  findCityByParent(String parent);

	 SkxdArea querySkxdAreaByAreaNo(String areaNo);

 	 public List<SkxdArea> querySkxdAreaListByExample(SkxdAreaExample skxdAreaExample);

	 public String getAreaNoByName(String name);

	public Page<SkxdArea> querySkxdAreaPage(Map params)throws Exception;

	public List<SkxdArea> findSelectedAreas(String userId)throws Exception;
}
